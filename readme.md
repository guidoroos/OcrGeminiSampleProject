# OCR Gemini Recipe Extractor Sample 

## Project description

This is a sample project demonstrating how to use CameraX, Google OCR text recognition and Google generative AI to extract recipes from a photo

## Project structure
the project uses MVVM structure with a single module. it uses jetpack compose inside the ui package, which has subpackages for screens and ui components.
it also use jetpack compose navigation. 

the ocr functionality with cameraX is in :
- CameraPreview.kt, OcrCaptureScreen.kt, RecipeViewModel.kt, OcrRepository.kt

the generative ai functionality is: 
- OcrCaptureScreen.kt, RecipeViewModel.kt, AiRepository.kt, GeminiPrompt.kt 

## setup
- clone the project
- create a api key for google generative AI on Google Ai Studio: https://aistudio.google.com/:
- click on getApiKey, create api key
- add the api key in local.properties file
- build the app project

## how to use
- open the app
- grant camera permission
- scan a recipe from a book or screen
- the app will extract the text and display it