import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    kotlin("platform.common")
}

dependencies {
    compile(kotlin("stdlib-common", "1.3.0"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.0.0")
}