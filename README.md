# [TVBillboard](https://github.com/javiergbravo/TVBillboard)

## 🌟 About
It simply app that loads a billboard from local JSON and display inside a RecyclerView as a GridLayout. This repository shows a clean code with MVVM architecture and use professional libraries with Kotlin language.
Use models for services and entities as application objects. The mapping is done in the datasource to provide a Resource object to ViewModel from Response of mock service (JSON). And ViewModel makes a LiveData from Resource to display in Activity or fragment.

![OS](https://img.shields.io/badge/OS-Android-3DDC84?logo=Android) ![Language](https://img.shields.io/badge/Language-Kotlin-0095D5?logo=kotlin) ![Environment](https://img.shields.io/badge/Environment-Android_Studio-3DDC84?logo=android-studio)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-brightgreen) ![View](https://img.shields.io/badge/View-ViewBinding-00B0EA) ![Observable](https://img.shields.io/badge/Observable-LiveData-CF202E)

## 📃 Libraries used
![minSDK](https://img.shields.io/badge/minSDK-v18-%230095D5) ![targetSDK](https://img.shields.io/badge/targetSDK-v30-CF202E)

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more.
- [Dagger 2](https://dagger.dev/) - Dependency Injection Framework.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Jetpack Dependency Injection Framework.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [GSON](https://github.com/google/gson) - Library that can be used to convert Java Objects into their JSON representation and JSON string to an equivalent Java object.
- [Glide](https://bumptech.github.io/glide) - An image loading library for Android.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
