package com.guidoroos.ocrgeminisample.model



data class UIStep(
    val id: Long? = null,
    val recipeId: Long?,
    var position: Int,
    val description: String = "",
    val timeSeconds: Long? = null
) {
    companion object {
        fun mocks() = listOf (
            UIStep(
                recipeId = 1,
                position = 1,
                description = "Mock Step 1",
                timeSeconds = 60
            ),
            UIStep(
                recipeId = 1,
                position = 2,
                description = "Mock Step 2",
                timeSeconds = 60
            ),
            UIStep(
                recipeId = 1,
                position = 3,
                description = "Mock Step 3",
                timeSeconds = 60
            )
        )
        fun mock() = mocks().first()
    }
}
