package com.guidoroos.ocrgeminisample.util


fun geminiPrompt(scan: String) = """
this input:    

$scan

______

You are given a recipe in the form of a long text.
 Be aware this input text is from OCR input, so you need to correct misread letters and words.
 
 Please extract the following details from the recipe:
    name: The name of the recipe (e.g., "Chocolate Cake").
    description: A brief description of the recipe (e.g., "A rich and moist chocolate cake with a smooth frosting").
    cuisine: The type of cuisine the recipe belongs to (e.g., "American").
    servings: The number of servings the recipe yields (e.g., 8).
    preparationMinutes: The time in minutes it takes to prepare the recipe (e.g., 30). it can also be two times for prep and cooking. in that case add them up together. 

Additionally, extract the following details:

    steps: A list of objects, where each object represents a step in the recipe instructions. Dont make the step description too long, split otherwise.
     Each object should have two fields: 
    
    - description: The step description (e.g., "Preheat the oven to 350°F").
    - timeSeconds(optional: only if time is mentioned in the step): The time in seconds it takes to complete the step (e.g., 1800).

    ingredients: A list of ingredients, where each ingredient is represented by an object with:
        amount: The quantity of the ingredient (e.g., "2" or null if not specified).
        denominator: optional, only if recipe contains 1/2, 1/4 etc.
        measure: The unit of measurement (e.g., "cups" or null if not specified).
        name: The name of the ingredient (e.g., "flour").

      
Ensure that if any of the fields are missing or unclear, you return null or an empty string for those fields.
If you are sure it is not a recipe, return "not a recipe"

Since the recipe can be in multiple languages, ensure that the extracted details reflect the correct language, using the context or the language most likely used for each field (e.g., the name, description, and cuisine might be in different languages depending on the recipe's origin).


Your final response is this, you only replace the values (like "name": "Chicken Curry" instead of "name" :Chocolate Cake"),
or "steps" : ["cut apple", "eat apple"] instead of "steps" : ["Preheat the oven to 350°F", "Mix the dry ingredients", "Bake for 30 minutes"]

{
  "name": "Chocolate Cake",
  "description": "A rich and moist chocolate cake with a smooth frosting",
  "cuisine": "American",
  "servings": 8,
  "preparationMinutes": 30,
  "steps": [
    { "description": "Preheat the oven to 350°F"},
    { "description": "Mix the dry ingredients"},
    { "description": "Bake for 30 minutes", "timeSeconds": 1800 }
  ],
  "ingredients": [
    {
      "amount": "2",
      "measure": "cups",
      "name": "flour",
       "categoryId": 2
    },
    {
      "amount": "1",
      "denominator": 2,
      "measure": "cup",
      "name": "sugar",
       "categoryId": 3
    }
  ]
}
"""

