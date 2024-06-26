rootProject.name = "json-lib"
include("json-core")

// the version for this comes from gradle.properties and not from the toml libs file
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// Where can we get external 3pp dependencies from?
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
