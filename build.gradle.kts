// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        // Navigation plugin
        classpath(
            group = "androidx.navigation",
            name = "navigation-safe-args-gradle-plugin",
            version = "2.3.0"
        )

        // Gradle plugins
        classpath(group = "com.android.tools.build", name = "gradle", version = "4.1.3")
        classpath(embeddedKotlin(module = "gradle-plugin"))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
//        maven {
//            name = "Nexus"
//            url = uri("https://nexus.int.imlab.by/repository/ikassa-backend")
//            credentials {
//                username = project.ext["nexusUsername"].toString()
//                password = project.ext["nexusPassword"].toString()
//            }
//        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}