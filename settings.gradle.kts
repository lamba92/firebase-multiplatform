rootProject.name = "firebase-multiplatform"

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

if (System.getProperty("user.name") != "root")
    include(
        ":core",
        ":auth",
        ":storage"
//        ":firestore"
//        ":storage-mobile"
    )