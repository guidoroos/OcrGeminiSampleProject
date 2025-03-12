package com.guidoroos.ocrgeminisample.util

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.guidoroos.ocrgeminisample.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.util.Locale

fun LocalDateTime.Companion.now() =
    Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

@Composable
fun Context.formatSeconds(seconds: Long?): String {
    if (seconds == null) return ""

    val hours = seconds / 3600
    val remainingMinutes = (seconds % 3600) / 60
    val minutes = (seconds % 3600) / 60
    val remainingSeconds = seconds % 60

    val hoursLabel = stringResource(id = R.string.hours_short)
    val minutesLabel = stringResource(id = R.string.minutes_short)

    val locale = Locale.getDefault()

    return when {
        hours > 0 -> String.format(locale, "%02d:%02d %s", hours, remainingMinutes, hoursLabel)
        minutes > 0 -> String.format(
            locale,
            "%02d:%02d %s",
            minutes,
            remainingSeconds,
            minutesLabel
        )

        else -> String.format(locale, "0:%02d %s", seconds, minutesLabel)
    }
}

fun <T> geminiExceptionHandler(
    tag: String? = "",
    state: MutableStateFlow<ResultOf<T>>
) = CoroutineExceptionHandler { _, exception ->
    val messageId = when (exception) {
        is com.google.ai.client.generativeai.common.SerializationException -> R.string.gemini_serialization_exception
        is com.google.ai.client.generativeai.common.ServerException -> R.string.gemini_server_exception
        is com.google.ai.client.generativeai.common.InvalidAPIKeyException -> R.string.gemini_invalid_api_key_exception
        is com.google.ai.client.generativeai.common.PromptBlockedException -> R.string.gemini_prompt_blocked_exception
        is com.google.ai.client.generativeai.common.UnsupportedUserLocationException -> R.string.gemini_unsupported_user_location_exception
        is com.google.ai.client.generativeai.common.InvalidStateException -> R.string.gemini_invalid_state_exception
        is com.google.ai.client.generativeai.common.ResponseStoppedException -> R.string.gemini_response_stopped_exception
        is com.google.ai.client.generativeai.common.RequestTimeoutException -> R.string.gemini_request_timeout_exception
        is com.google.ai.client.generativeai.common.UnknownException -> R.string.gemini_unknown_exception
        is com.google.ai.client.generativeai.common.QuotaExceededException -> R.string.gemini_quota_exceeded_exception
        is TimeoutCancellationException -> R.string.gemini_request_timeout_exception
        is com.google.gson.JsonSyntaxException -> R.string.gson_serialization_exception
        is com.google.gson.JsonIOException -> R.string.gson_serialization_exception
        else -> R.string.gemini_unknown_exception
    }

    val customMessage = when (exception) {
        is com.google.ai.client.generativeai.common.PromptBlockedException,
        is com.google.ai.client.generativeai.common.InvalidStateException,
        is com.google.ai.client.generativeai.common.UnknownException -> exception.message

        else -> null
    }

    Log.e(tag, exception.message ?: "")
    state.value = ResultOf.Error(
        errorResourceId = messageId,
        customErrorMessage = customMessage
    )
}

