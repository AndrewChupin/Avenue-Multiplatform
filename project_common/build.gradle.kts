import com.avenue.config.AvenueConfig
import org.jetbrains.kotlin.config.KotlinCompilerVersion


plugins {
    kotlin("platform.common")
}


dependencies {
    compile(project(":core_common"))
    compile(AvenueConfig.Common.Libs.Ktor)
}