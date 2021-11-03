plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.google.gms.google-services")

}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    // Kotlin
    implementation(embeddedKotlin("stdlib-jdk8"))
    implementation("com.google.firebase:firebase-config-ktx:21.0.0")

    // Kotlin coroutines
    val coroutinesVersion = "1.3.8"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    val timberVersion = "4.7.1"
    api("com.jakewharton.timber:timber:$timberVersion")


    // Lifecycle
    val lifecycleVersion = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // Koin
    val koinVersion = "2.1.6"
    api("org.koin:koin-androidx-scope:$koinVersion")
    api("org.koin:koin-androidx-viewmodel:$koinVersion")
    api("org.koin:koin-androidx-fragment:$koinVersion")
    api("org.koin:koin-androidx-ext:$koinVersion")


    // Navigation
    val navigationVersion = "2.3.0"
    api("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    api("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
}