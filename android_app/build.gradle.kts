import com.avenue.config.AvenueConfig
import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.example.android_app"
        minSdkVersion(17)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
    }

    compileOptions {
        setTargetCompatibility(JavaVersion.VERSION_1_8)
        setSourceCompatibility(JavaVersion.VERSION_1_8)
    }
}

dependencies {
    implementation(project(":android_project"))
}
