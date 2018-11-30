import com.avenue.config.AvenueConfig
import org.jetbrains.kotlin.config.KotlinCompilerVersion


plugins {
    kotlin("platform.common")
}

sourceSets {
    getByName("main").getJava().srcDir("src/main/kotlin")
}


dependencies {
    compile(project(":core_common"))
    compile(AvenueConfig.Common.Libs.Ktor)
}