/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiplatform)
    plugin(Deps.Plugins.mobileMultiplatform)
    plugin(Deps.Plugins.mokoResources)
    plugin(Deps.Plugins.mavenPublish)
}

group = "dev.icerock.moko"
version = Deps.mokoNetworkVersion

dependencies {
    commonMainImplementation(Deps.Libs.MultiPlatform.kotlinSerialization)

    commonMainApi(Deps.Libs.MultiPlatform.coroutines)
    commonMainApi(Deps.Libs.MultiPlatform.ktorClient)
    commonMainApi(Deps.Libs.MultiPlatform.ktorClientLogging)

    commonMainApi(Deps.Libs.MultiPlatform.mokoErrors)
    commonMainApi(Deps.Libs.MultiPlatform.mokoResources)

    commonMainImplementation(project(":network"))

    androidMainImplementation(Deps.Libs.Android.appCompat)
}

multiplatformResources {
    multiplatformResourcesPackage = "dev.icerock.moko.network.errors"
}

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/moko/moko-network/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }
}
