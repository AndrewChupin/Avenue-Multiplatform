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
    expectedBy(project(AvenueConfig.Modules.CommonCore))
    api(AvenueConfig.Android.Libs.Kotlin)
    api(AvenueConfig.Android.Libs.KotlinReflect)
    api(AvenueConfig.Android.Libs.AppCompat)
    api(AvenueConfig.Android.Libs.CardView)
    api(AvenueConfig.Android.Libs.Design)
    api(AvenueConfig.Android.Libs.Support)
    api(AvenueConfig.Android.Libs.RecyclerView)
    api(AvenueConfig.Android.Libs.Constraints)
    api(AvenueConfig.Android.Libs.Coroutines)
    api(AvenueConfig.Android.Libs.LifecycleCommon)
    api(AvenueConfig.Android.Libs.LifecycleExt)
}
