plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinParcelizePlugin)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.kapt)
    id(BuildPlugins.jacocoAndroid)
    id(BuildPlugins.safeargs)
}

jacoco {
    toolVersion = Versions.jacoco
}

android {

    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)

    android.buildFeatures.dataBinding = true
    android.buildFeatures.viewBinding = true

    defaultConfig {
        applicationId = "com.n26"
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = "com.n26.runner.MockTestRunner"
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // TODO before submission we need to clean this list of dependencies
    dependencies {
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        implementation(project(BuildModules.presentationModule))
        implementation(project(BuildModules.domainModule))
        implementation(project(BuildModules.dataModule))
        implementation(project(BuildModules.networkModule))
        implementation(project(BuildModules.sharedModule))

        implementation(Libraries.kotlinStdLib)
        implementation(Libraries.coreKtx)

        // Material and AndroidX
        implementation(Libraries.constraintLayout)
        implementation(Libraries.appCompat)
        implementation(Libraries.swiperefreshlayout)
        implementation(Libraries.material)

        // Firebase
        implementation(platform(Libraries.bom))
        implementation(Libraries.crashlytics)

        // DI - KOIN
        implementation(Libraries.koin)
        implementation(Libraries.koinViewModel)

        // Debug - for debug builds only
        implementation(Libraries.timber)
        debugImplementation(Libraries.leakCanary)
        debugImplementation(Libraries.stetho)

        // UI Tests
        androidTestImplementation(TestLibraries.espresso)
        androidTestImplementation(TestLibraries.kakao)

        // Instrumentation Tests
        androidTestImplementation(TestLibraries.runner)
        androidTestImplementation(TestLibraries.rules)
        androidTestImplementation(TestLibraries.koinTest)
        androidTestImplementation(TestLibraries.androidXJUnit)
        androidTestImplementation(TestLibraries.androidXTestCore)
        androidTestImplementation(TestLibraries.androidMockK)

        // Unit Tests
        testImplementation(TestLibraries.jUnit)
        testImplementation(TestLibraries.mockWebServer)
        testImplementation(TestLibraries.mockK)
        testImplementation(TestLibraries.roboelectric)
        testImplementation(TestLibraries.truth)
        testImplementation(TestLibraries.runner)
        testImplementation(TestLibraries.androidXJUnit)
        testImplementation(TestLibraries.archComponentTest)
        testImplementation(TestLibraries.liveDataTesting)

        implementation(Libraries.workManager)
    }
}