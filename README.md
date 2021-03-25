# N26

👀 Create an Android application that will fetch information about the current Bitcoin market price from an API (suggested resources will be provided below, however you may decide to use other resources) and display the data in a graph of your choice.

### Prerequisites

Before every commit, make sure you run the following commands:

```shell script
./codeAnalysis
```

To check for dependency updates, run the following command:

```shell script
./gradlew dependencyUpdate
```

Refer to this [issue](https://github.com/gradle/gradle/issues/10248), if you get any issues running the lint commands on the terminal :rocket:

## UI Inspiration

<p align="center">
  <img src="https://github.com/jumaallan/n26/blob/master/Screenshot%202021-03-25%20at%2018.13.42.png" width="500" alt="App UI">
</p>

## Must-haves:

* Use of Kotlin.
* Good project structure - well structured packages, files and resources that will scale as the project grows.
* Attention to detail - tidy code that is easy to read, consistent formatting, meaningful naming conventions, no IDE warnings, no unused code, etc.
* Architecture design that promotes SOLID principles.
* Dependency injection.
* All code containing logic should be tested (Unit, UI).
* Efficient and responsive layout design.

## Good-to-haves:
* Good UX and well polished UI
* Multi-modular project structure
* Gracefully handled loading/error states.
* Instrumentation tests.
* Handling configuration changes/process death

## Suggested Resources:

* Blockchain Charts - https://www.blockchain.com/charts/
* Blockchain Charts API Documentation - https://blockchain.info/api/charts_api


## Tech-stack

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations.
    * [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - handle the stream of data asynchronously that executes sequentially.
    * [KOIN](https://insert-koin.io/) - a pragmatic lightweight dependency injection framework.
    * [Jetpack](https://developer.android.com/jetpack)
        * [Room](https://developer.android.com/topic/libraries/architecture/room) - a persistence library provides an abstraction layer over SQLite.
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder.
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes.
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way.
    * [Timber](https://github.com/JakeWharton/timber) - a highly extensible android logger.
    * [Leak Canary](https://github.com/square/leakcanary) - a memory leak detection library for Android.

* Architecture
    * Clean Architecture
    * MVVM - Model View View Model
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/)) - a simple framework to write repeatable tests.
    * [MockK](https://github.com/mockk) - mocking library for Kotlin
    * [Kluent](https://github.com/MarkusAmshove/Kluent) - Fluent Assertion-Library for Kotlin
    * [Kakao](https://github.com/agoda-com/Kakao) - Nice and simple DSL for Espresso in Kotlin
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For reference purposes, here's an [article explaining the migration](https://medium.com/@evanschepsiror/migrating-to-kotlin-dsl-4ee0d6d5c977).
    * Plugins
        * [Ktlint](https://github.com/JLLeitschuh/ktlint-gradle) - creates convenient tasks in your Gradle project that run ktlint checks or do code auto format.
        * [Detekt](https://github.com/detekt/detekt) - a static code analysis tool for the Kotlin programming language.
        * [Spotless](https://github.com/diffplug/spotless) - format java, groovy, markdown and license headers using gradle.
        * [Dokka](https://github.com/Kotlin/dokka) - a documentation engine for Kotlin, performing the same function as javadoc for Java.
        * [jacoco](https://github.com/jacoco/jacoco) - a Code Coverage Library
* CI/CD
    * Github Actions
    * [Fastlane](https://fastlane.tools)


## Dependencies

All the dependencies (external libraries) are defined in the single place - Gradle `buildSrc` folder. This approach allows to easily manage dependencies and use the same dependency version across all modules.
