package com.avenue.config.common


object CommonLibs {

    private val Versions = CommonVersions

    const val KotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
    const val AndroidPlugin = "com.android.tools.build:gradle:${Versions.AndroidGradle}"
    const val Ktor = "io.ktor:ktor-client:${Versions.Ktor}"
}