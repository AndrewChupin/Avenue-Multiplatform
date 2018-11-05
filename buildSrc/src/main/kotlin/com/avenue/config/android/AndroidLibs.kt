package com.avenue.config.android

object AndroidLibs {

    private val Versions = AndroidVersions

    const val KtorAndroid ="io.ktor:ktor-client-android:${Versions.Ktor}"
    const val Ktor ="io.ktor:ktor-client-core-jvm:${Versions.Ktor}"

    const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines}"

    const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin}"
    const val KotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.Kotlin}"

    const val Constraints = "com.android.support.constraint:constraint-layout:${Versions.Constraints}"

    const val Support = "com.android.support:support-v4:${Versions.Support}"
    const val Design = "com.android.support:design:${Versions.Support}"
    const val AppCompat = "com.android.support:appcompat-v7:${Versions.Support}"
    const val CardView = "com.android.support:cardview-v7:${Versions.Support}"
    const val RecyclerView = "com.android.support:recyclerview-v7:${Versions.Support}"
    const val LifecycleExt = "android.arch.lifecycle:extensions:${Versions.ArchComponents}"
    const val LifecycleCommon = "android.arch.lifecycle:common-java8:${Versions.ArchComponents}"
}