plugins {
    alias(libs.plugins.kotlin.jvm) apply false
}

subprojects {
    // configure the java version for all modules in a single place
    plugins.withType(JavaPlugin::class) {
        configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_21.toString()
        kotlinOptions.javaParameters = true
    }
}

tasks.register("build") {
    // Adding a synthetic build task to the root project to allow us to run the buildHealth task
}

// this causes us to do the dependency analysis on every build
tasks.named("build") {
    dependsOn("buildHealth")
}
