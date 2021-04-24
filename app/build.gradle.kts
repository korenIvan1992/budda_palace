plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.android.buddapalace"

        minSdkVersion(21)
        targetSdkVersion(30)

    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions("default")


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    android {
        buildFeatures {
            viewBinding = true
            dataBinding = true
        }
    }
}

dependencies {
    // Modules
//    api(project(":core"))
//    api(project(":data"))

    // Kotlin
    implementation(embeddedKotlin("stdlib-jdk8"))

    // Kotlin coroutines
    val coroutinesVersion = "1.3.8"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Joda time
    implementation("net.danlew:android.joda:2.10.7.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:2.12.0") {
        //compile('com.some.project:some-module:0.1') {
            // Exclude joda-time from this dependency to remove the errors.
        exclude(module="joda-time")
        //}
    }

    // Android
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.0.0")

    // UI
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.drawerlayout:drawerlayout:1.1.1")
    implementation("com.github.razir.progressbutton:progressbutton:2.1.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Koin
    val koinVersion = "2.1.6"
    implementation("org.koin:koin-androidx-scope:$koinVersion")
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")
    implementation("org.koin:koin-androidx-fragment:$koinVersion")
    implementation("org.koin:koin-androidx-ext:$koinVersion")

    // Navigation
    val navigationVersion = "2.3.0"
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")

    // List
    val pagingVersion = "2.1.2"
    implementation("androidx.paging:paging-runtime:$pagingVersion")

    // Lifecycle
    val lifecycleVersion = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // Extensions
    implementation("androidx.core:core-ktx:1.3.1")

    // Auto service
    val autoServiceVersion = "1.0-rc7"
    implementation("com.google.auto.service:auto-service:$autoServiceVersion")
    kapt("com.google.auto.service:auto-service:$autoServiceVersion")
}