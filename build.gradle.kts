plugins {
    alias(libs.plugins.kotlin.jvm) apply false

    alias(libs.plugins.dependency.analysis)
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

dependencyAnalysis {
    issues {
        all {
            onAny {
                severity("fail")
            }
            // quarkus generates these source sets that we don't need/want to analysis
            ignoreSourceSet(
                "native-test",
                "quarkus-generated-sources",
                "quarkus-test-generated-sources"
            )
        }
    }
}

tasks.register("build") {
    // Adding a synthetic build task to the root project to allow us to run the buildHealth task
}

// this causes us to do the dependency analysis on every build
tasks.named("build") {
    dependsOn("buildHealth")
}
