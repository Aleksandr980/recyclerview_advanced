// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()

    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.52")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.5")
        classpath("com.android.tools.build:gradle:8.7.3")
    }
}
plugins {
    id("com.android.application") version ("8.2.0") apply false
    id("com.android.library") version ("8.2.0") apply false
    id("org.jetbrains.kotlin.android") version ("1.8.20") apply false
}

