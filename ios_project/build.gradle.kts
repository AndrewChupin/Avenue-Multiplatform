plugins {
    id("konan")
}

konan {
    targets = mutableListOf("iphone_sim")
}

konanArtifacts {
    framework(name = "AP", configureAction = Action {
        enableMultiplatform(true)
    })
}


dependencies {
    expectedBy(project(":core_common"))
    expectedBy(project(":project_common"))
}