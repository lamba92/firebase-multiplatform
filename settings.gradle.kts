rootProject.name = "firebase-multiplatform"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "de.undercouch.download" -> useModule("de.undercouch:gradle-download-task:4.0.2")
            }
        }
    }
}

plugins {
    @Suppress("UnstableApiUsage")
    `gradle-enterprise`
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlwaysIf(!System.getenv("CI").isNullOrEmpty())
    }
}

include(
    ":core",
    ":auth",
    ":storage"
//    ":storage-mobile"
)