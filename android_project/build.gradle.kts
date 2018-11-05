import com.avenue.config.AvenueConfig
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    id("com.android.library")
    kotlin("platform.android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
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
    expectedBy(project(":project_common"))
    compile(project(AvenueConfig.Modules.AndroidCore))
    api(AvenueConfig.Android.Libs.Ktor)
    api(AvenueConfig.Android.Libs.KtorAndroid)
}
