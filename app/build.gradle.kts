plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    kotlin("kapt")
}
android {

    namespace = "com.example.kalavidarabalaga"
    compileSdk = 36

    defaultConfig {

        applicationId = "com.example.kalavidarabalaga"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {

        jvmTarget = "11"
    }

    buildFeatures {

        compose = true
        viewBinding = true
    }

    composeOptions {

        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation("androidx.compose.runtime:runtime-livedata:1.7.5")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")

    implementation("androidx.room:room-ktx:2.6.1")

    kapt("androidx.room:room-compiler:2.6.1")

    implementation("androidx.room:room-ktx:2.6.1")

    kapt("androidx.room:room-compiler:2.6.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
    implementation("io.coil-kt:coil-compose:2.6.0")

    // CORE
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // ACTIVITY
    implementation(libs.androidx.activity.compose)

    // COMPOSE
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation("io.coil-kt:coil-compose:2.7.0")

    // ROOM DATABASE
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    kapt("androidx.room:room-compiler:2.6.1")

    // VIEWMODEL
    implementation(
        "androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0"
    )

    implementation(
        "androidx.lifecycle:lifecycle-livedata-ktx:2.8.0"
    )

    // COROUTINES
    implementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
    )

    // RECYCLERVIEW
    implementation(
        "androidx.recyclerview:recyclerview:1.3.2"
    )

    // GLIDE
    implementation(
        "com.github.bumptech.glide:glide:4.16.0"
    )

    kapt(
        "com.github.bumptech.glide:compiler:4.16.0"
    )

    // NAVIGATION
    implementation(
        "androidx.navigation:navigation-fragment-ktx:2.7.7"
    )

    implementation(
        "androidx.navigation:navigation-ui-ktx:2.7.7"
    )

    // MATERIAL DESIGN
    implementation(
        "com.google.android.material:material:1.11.0"
    )

    // TESTING
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)

    androidTestImplementation(
        libs.androidx.espresso.core
    )

    androidTestImplementation(
        platform(libs.androidx.compose.bom)
    )

    androidTestImplementation(
        libs.androidx.compose.ui.test.junit4
    )

    debugImplementation(
        libs.androidx.compose.ui.tooling
    )

    debugImplementation(
        libs.androidx.compose.ui.test.manifest
    )
}