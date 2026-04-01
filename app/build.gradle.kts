plugins {
    alias(libs.plugins.app.android.application)
    alias(libs.plugins.app.compose)
}

android {
    namespace = "com.example.android_tender_platform"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.android_tender_platform"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.x.lifecycle.runtime.ktx)
    implementation(libs.x.activity.compose)
}