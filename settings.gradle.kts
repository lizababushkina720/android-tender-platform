pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android_tender_platform"
include(":app")
include(":core")
include(":core:domain")
include(":core:data")
include(":features")
include(":features:tenders")
include(":features:profile")
include(":features:bids")
include(":features:chat")
include(":features:common")
