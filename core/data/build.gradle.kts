plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.app.room)
}

android {
    namespace = "com.example.data"

}

dependencies {


    implementation(project(path = ":core:domain"))
    implementation(project(path = ":core:network"))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)


    implementation(libs.retrofit)
}