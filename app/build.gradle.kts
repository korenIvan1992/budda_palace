plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    kotlin("kapt")

}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.android.buddhapalace.quotes"
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

    productFlavors {
        val appName = "Quotes"

        create("prod") {
            versionCode = 1
            versionName = "1.0"
            resValue("string", "app_name", appName)
        }
    }

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
    api(project(":core"))
    api(project(":data"))

    // Kotlin
    implementation(embeddedKotlin("stdlib-jdk8"))
    implementation("androidx.cardview:cardview:1.0.0")

    val firebaseVersion = "28.1.0"
    implementation  ("com.google.firebase:firebase-bom:$firebaseVersion")
    implementation ("com.google.firebase:firebase-crashlytics:18.0.1")

    val firebaseMessagingVersion = "20.1.0"
    implementation("com.google.firebase:firebase-messaging:$firebaseMessagingVersion")


    // Kotlin coroutines
    val coroutinesVersion = "1.3.8"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Joda time
    val jodaTimeVersion = "2.10.7.2"
    implementation("net.danlew:android.joda:$jodaTimeVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:2.12.0") {
        //compile('com.some.project:some-module:0.1') {
            // Exclude joda-time from this dependency to remove the errors.
        exclude(module="joda-time")
        //}
    }


    // Android
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.0.0")

    // UI
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.drawerlayout:drawerlayout:1.1.1")
    implementation("com.github.razir.progressbutton:progressbutton:2.1.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // List
    val pagingVersion = "2.1.2"
    implementation("androidx.paging:paging-runtime:$pagingVersion")

    // Lifecycle
    val lifecycleVersion = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // Extensions
    val extensionsVersion = "1.3.1"
    implementation("androidx.core:core-ktx:$extensionsVersion")

    // Auto service
    val autoServiceVersion = "1.0-rc7"
    implementation("com.google.auto.service:auto-service:$autoServiceVersion")
    kapt("com.google.auto.service:auto-service:$autoServiceVersion")

    val cardStackViewVersion = "2.3.4"
    implementation ("com.yuyakaido.android:card-stack-view:$cardStackViewVersion")

}