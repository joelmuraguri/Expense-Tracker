pluginManagement {
    repositories {
        google()
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

rootProject.name = "Wallet"
include(":app")
include(":home:home_presentation")
include(":profile:profile_presentation")
include(":history:history_presentation")
include(":overview:overview_presentation")
include(":edit:edit_presentation")
include(":core:design")
