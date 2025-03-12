package com.guidoroos.ocrgeminisample.model

import android.content.Context
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

data class UIIngredient(
    val id: Long? = null,
    val recipeId: Long? = null,
    val recipeName: String? = null,
    val name: String = "",
    val measure: String? = null,
    val amount: Float? = null,
    val denominator: Int? = null,
    var position: Int,
    val isRecurring: Boolean = false,
    val isChecked: Boolean = false
) {
    companion object {
        fun mocks() = listOf (
            UIIngredient(
                name = "1 cup flour",
                measure = "cup",
                amount = 1f,
                position = 1
            ),
            UIIngredient(
                name = "1/2 cup sugar",
                measure = "cup",
                amount = 0.5f,
                denominator = 2,
                position = 2
            ),
        )
        fun mock() = mocks().first()

    }
}

fun UIIngredient.toFormattedString(context: Context): String {
    val amountText = amount?.let { context.formatFloat(it) } ?: ""
    val measureText = measure?.let { "$it " } ?: ""

    return if (amount != null) {
        "$amountText $measureText$name"
    } else {
        "$measureText$name"
    }
}

fun Context.formatFloat(value: Float): String {
    return if (value % 1 == 0f) {
        value.toInt().toString()
    } else {
        val df1 = DecimalFormat("#.#", DecimalFormatSymbols(Locale.getDefault()))
        val df2 = DecimalFormat("#.##", DecimalFormatSymbols(Locale.getDefault()))
        val df3 = DecimalFormat("#.###", DecimalFormatSymbols(Locale.getDefault()))

        when {
            value >= 100 -> df1.format(value)
            value >= 10 -> df2.format(value)
            else -> df3.format(value)
        }
    }
}

