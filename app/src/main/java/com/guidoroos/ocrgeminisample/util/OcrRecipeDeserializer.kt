package com.guidoroos.ocrgeminisample.util

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.guidoroos.ocrgeminisample.model.OcrIngredient
import com.guidoroos.ocrgeminisample.model.OcrRecipe
import com.guidoroos.ocrgeminisample.model.OcrStep
import java.lang.reflect.Type

class OcrRecipeDeserializer : JsonDeserializer<OcrRecipe> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): OcrRecipe {
        val jsonObject = json.asJsonObject

        val name = try {
            jsonObject.get("name")?.asString ?: "Unknown"
        } catch (e: Exception) {
            "Unknown"
        }

        val description = try {
            jsonObject.get("description")?.asString
        } catch (e: Exception) {
            null
        }

        val cuisine = try {
            jsonObject.get("cuisine")?.asString
        } catch (e: Exception) {
            null
        }

        val servings = try {
            jsonObject.get("servings")?.asString
        } catch (e: Exception) {
            null
        }

        val preparationMinutes = try {
            jsonObject.get("preparationMinutes")?.asString
        } catch (e: Exception) {
            null
        }

        val steps = try {
            jsonObject.get("steps")?.asJsonArray?.map { element ->
                context.deserialize<OcrStep>(element, OcrStep::class.java)
            } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }

        val ingredients: List<OcrIngredient> = try {
            jsonObject.get("ingredients")
                ?.takeIf { it.isJsonArray }?.asJsonArray?.mapNotNull { element ->
                try {
                    context.deserialize<OcrIngredient>(element, OcrIngredient::class.java)
                } catch (e: Exception) {
                    null // Skip invalid elements
                }
            } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }

        return OcrRecipe(
            name = name,
            description = description,
            cuisine = cuisine,
            servings = servings,
            preparationMinutes = preparationMinutes,
            steps = steps,
            ingredients = ingredients
        )
    }
}

