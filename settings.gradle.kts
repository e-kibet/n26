pluginManagement {
    repositories {
        jcenter()
        google()
        gradlePluginPortal()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }

    plugins {
        id("com.android.application") version "4.1.0"
        id("org.jetbrains.kotlin.android") version "1.4.10"
        id("org.jetbrains.kotlin.android.extensions") version "1.4.10"
        id("com.android.library") version "4.1.0"
        id("com.google.firebase.crashlytics") version "2.1.0"
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library" -> useModule("com.android.tools.build:gradle:4.1.1")
                "com.google.firebase.crashlytics" -> useModule("com.google.firebase:firebase-crashlytics-gradle:2.1.0")
            }
        }
    }
}

include("app")
rootProject.name = "N26"

include(":presentation")
include(":domain")
include(":data:database")
include(":data:network")
include(":shared")