pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "brain-ring"
include("brain-ring-app")
include("brain-ring-model")
include("brain-ring-dao")
include("brain-ring-service")
