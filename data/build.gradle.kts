plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
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
    // Modules
    api(project(":core"))

    // Kotlin
    implementation(embeddedKotlin("stdlib-jdk8"))

    // Android
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.0.0")

    // JWT decoder
    val jwtDecodeVersion = "2.0.0"
    implementation("com.auth0.android:jwtdecode:$jwtDecodeVersion")

    // Lifecycle
    val lifecycleVersion = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    // Database
    val roomVersion = "2.2.5"
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Network
    val okHttpVersion = "4.8.1"
    val jacksonVersion = "2.12.0"
    val retrofitVersion = "2.9.0"
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:2.12.0") {
        //compile('com.some.project:some-module:0.1') {
        // Exclude joda-time from this dependency to remove the errors.
        exclude(module = "joda-time")
        //}
    }
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-jackson:$retrofitVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-modules-java8:$jacksonVersion")

    implementation("com.google.code.gson:gson:2.8.6")

    //implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    // Koin
    val koinVersion = "2.1.6"
    implementation("org.koin:koin-core:$koinVersion")

    // Auto service
    val autoServiceVersion = "1.0-rc7"
    implementation("com.google.auto.service:auto-service:$autoServiceVersion")
    kapt("com.google.auto.service:auto-service:$autoServiceVersion")
}