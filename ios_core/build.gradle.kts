import org.jetbrains.kotlin.gradle.plugin.konan.KonanArtifactContainer
import org.jetbrains.kotlin.ir.backend.js.compile

buildscript {
    repositories {
        jcenter()

        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(kotlin("native-gradle-plugin", "1.3.10"))
    }
}

plugins {
    id("konan")
    id("kotlin-multiplatform")
}

repositories {
    jcenter()
}


konan {
    targets = mutableListOf("iphone_sim")

    konanArtifacts {
        framework(name = "AC", configureAction = Action {
            enableMultiplatform(true)
        })
    }
}

dependencies {
    expectedBy(project(":core_common"))
}
