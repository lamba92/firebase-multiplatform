rootProject.name = "firebase-multiplatform"

plugins {
    `gradle-enterprise`
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlwaysIf(!System.getenv("CI").isNullOrEmpty())
    }
}

include(":core", ":auth", ":storage", ":storage-mobile")
enableFeaturePreview("GRADLE_METADATA")