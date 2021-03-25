object Versions {

    // Material and androidX
    const val material = "1.3.0-rc01"
    const val appCompat = "1.3.0-alpha02"
    const val constraintLayout = "2.0.1"
    const val navigation = "2.3.1"
    const val swiperefreshlayout = "1.2.0-alpha01"

    // Logging - debug builds
    const val timber = "4.7.1"
    const val leakCanary = "2.4"
    const val stetho = "1.5.1"
    const val chucker = "3.4.0"

    // Kotlin
    const val kotlinVersion = "1.4.21"
    const val coreKtx = "1.5.0-beta01"

    // Gradle Plugins
    const val ktlint = "9.3.0"
    const val detekt = "1.16.0"
    const val spotless = "5.9.0"
    const val jacoco = "0.8.4"
    const val dokka = "1.4.20"
    const val gradleVersionsPlugin = "0.29.0"
    const val slackKeeper = "0.7.0"

    // tests
    const val junit = "4.13"
    const val junitTest = "1.1.2"
    const val espresso = "3.4.0-alpha03"
    const val roboelectric = "4.5-beta-1"
    const val androidXJUnit = "1.1.1"
    const val truth = "1.0.1"
    const val mockWebServer = "4.8.1"
    const val androidXTestCore = "1.3.0"
    const val runner = "1.3.1-alpha03"
    const val rules = "1.3.0"
    const val archComponentTest = "2.1.0"
    const val kakao = "2.3.4"
    const val mockK = "1.10.0"
    const val liveDataTesting = "1.1.2"
}

object BuildPlugins {
    //All the build plugins are added here
    const val dynamicFeature = "com.android.dynamic-feature"
    const val androidLibrary = "com.android.library"
    const val kapt = "kotlin-kapt"
    const val ktlintPlugin = "org.jlleitschuh.gradle.ktlint"
    const val detektPlugin = "io.gitlab.arturbosch.detekt"
    const val dokkaPlugin = "org.jetbrains.dokka"
    const val spotlessPlugin = "com.diffplug.spotless"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinParcelizePlugin = "org.jetbrains.kotlin.plugin.parcelize"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val slackKeeper = "com.slack.keeper"
    const val jacocoAndroid = "com.hiya.jacoco-android"
    const val safeargs = "androidx.navigation.safeargs.kotlin"
}

object Libraries {
    // androidX and Material
    const val material = "com.google.android.material:material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Logging - debug builds
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val chunkerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chunkerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
}

object TestLibraries {
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val jUnit = "junit:junit:${Versions.junit}"
    const val jUnitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
    const val androidXJUnit = "androidx.test.ext:junit:${Versions.androidXJUnit}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    const val androidXTestCore = "androidx.test:core:${Versions.androidXTestCore}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val rules = "androidx.test:rules:${Versions.rules}"
    const val archComponentTest =
        "androidx.arch.core:core-testing:${Versions.archComponentTest}"
    const val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"
    const val mockK = "io.mockk:mockk:${Versions.mockK}"
    const val androidMockK = "io.mockk:mockk-android:${Versions.mockK}"
    const val liveDataTesting = "com.jraska.livedata:testing-ktx:${Versions.liveDataTesting}"
}

object AndroidSdk {
    const val minSdkVersion = 21
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
}