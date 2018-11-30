
buildscript {
    repositories {
        jcenter()

        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-native-gradle-plugin:1.3.10")
    }
}


plugins {
    id("konan")
}

konan {
    targets = mutableListOf("iphone_sim")
}

konanArtifacts {
    framework(name = "AP", configureAction = Action {
        enableMultiplatform(true)
        enableOptimizations(true)
        enableDebug(true)
        dumpParameters(false)
        measureTime(false)
    })
}


dependencies {
    expectedBy(project(":core_common"))
    expectedBy(project(":project_common"))
}