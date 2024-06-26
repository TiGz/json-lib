rootProject.name = "json-lib"
include("json-core")

// Where can we get external 3pp dependencies from?
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
