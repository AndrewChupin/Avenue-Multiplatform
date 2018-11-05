import com.avenue.config.AvenueConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
}

buildscript {
    repositories {
        google()
        jcenter()

        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
        maven("https://kotlin.bintray.com/kotlinx")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.0")
        classpath("org.jetbrains.kotlin:kotlin-native-gradle-plugin:0.9")
    }
}


allprojects {
    repositories {
        google()
        jcenter()
        maven("https://kotlin.bintray.com/ktor")
        maven("https://kotlin.bintray.com/kotlinx")
    }

    dependencies {
        subprojects.forEach {
            archives(it)
        }
    }
}
