# 📸 OCR Gemini Recipe Extractor (AutoChef Showcase)

A high-performance Android sample demonstrating the core engine of my **AutoChef** application. This project showcases the integration of **CameraX**, **Google ML Kit OCR**, and **Google Generative AI (Gemini)** to transform raw images of handwritten or printed recipes into structured digital data.

**[View AutoChef on Google Play](https://play.google.com/store/apps/details?id=com.guidoroos.cookbook&hl=en)**

---

### 💡 The "Analytical AI" Potential
This project serves as a proof-of-concept for **Intelligent Data Extraction** in regulated or complex logic environments. By combining computer vision with LLMs, it demonstrates:
* **Precision Extraction:** Moving beyond simple text recognition to context-aware recipe parsing (ingredients, steps, and metadata).
* **Seamless UX:** A "Scan-to-Digital" workflow that handles real-world camera latency and image processing.
* **Modern AI Integration:** Implementation of the Gemini Pro API for real-time natural language processing on mobile.

---

### 🛠️ Tech Stack
* **Language:** 100% Kotlin
* **Framework:** Jetpack Compose (Declarative UI)
* **Vision:** CameraX + Google ML Kit (OCR)
* **AI:** Google Generative AI SDK (Gemini)
* **Architecture:** MVVM with clean sub-packaging for UI and Data layers

### ⚙️ Key Engineering Features
* **Reactive UI:** Full Jetpack Compose Navigation for a fluid, single-module transition between scanning and results.
* **Separated Repositories:** Distinct logic for OCR (`OcrRepository`) and AI (`AiRepository`) to ensure clean testing and maintenance.
* **Structured Prompts:** Centralized `GeminiPrompt.kt` to ensure consistent output from unstructured scan data.

### 📈 Enterprise-Grade Standards
Even as a showcase sample, this follows strict senior-level patterns:
* **Privacy-First:** Localized OCR processing before hitting the AI layer.
* **Secure Configuration:** Utilizes `local.properties` for API key management, following industry-standard security practices.

### 🤝 Available for Hire
I specialize in **KMP, AI-Integrated Mobile Apps, and Mobile Native (Kotlin/Swift)**. 

**[Contact me via LinkedIn](www.linkedin.com/in/guido-roos91)**

---

### 🛠️ Build and Run

1. **Obtain API Key:** Create a key at [Google AI Studio](https://aistudio.google.com/).
2. **Configure Security:** Add your key to your `local.properties` file:
   ```properties
   # Add this line to local.properties
   apiKey=YOUR_GEMINI_API_KEY

    Execution: - Build the project and grant camera permissions on launch.
   Scan any recipe from a book or screen.
    The app will extract the text, process it via Gemini, and display the structured recipe.
