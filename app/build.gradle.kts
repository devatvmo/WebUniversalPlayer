plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.webuniversalplayer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.webuniversalplayer"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0-alpha.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        // AGP 8+ does not generate BuildConfig unless explicitly enabled.
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")

    // Reserved for the optional native playback fallback in a later phase.
    implementation("androidx.media3:media3-exoplayer:1.5.1")

    testImplementation("junit:junit:4.13.2")
}
