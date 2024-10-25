plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.pokemonexam.android.hilt)
    alias(libs.plugins.secrets)
}

android {
    namespace = "com.xsoftcdmx.network"
    buildFeatures {
        buildConfig = true
    }
}

secrets{
    defaultPropertiesFileName = "constants.properties"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(project(":core:common"))
}