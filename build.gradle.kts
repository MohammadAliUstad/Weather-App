buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin.v2511)
    }
}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}
apply(plugin = "org.jetbrains.kotlin.jvm")