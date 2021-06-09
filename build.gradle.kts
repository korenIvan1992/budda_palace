// Top-level build file where you can add configuration options common to all sub-projects/modules.

 buildscript {
    val kotlin_version by extra("1.5.10")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Navigation plugin
        classpath(group = "androidx.navigation",
            name = "navigation-safe-args-gradle-plugin",
            version = "2.3.0"
        )
        //Google service

        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.7.0")
        classpath ("com.google.gms:google-services:4.3.8")
        // Gradle plugins
        classpath(group = "com.android.tools.build", name = "gradle", version = "4.2.1")
        classpath(embeddedKotlin(module = "gradle-plugin"))
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}