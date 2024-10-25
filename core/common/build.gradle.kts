plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.pokemonexam.android.hilt)
}

android {
    namespace = "com.xsoft.pokemonexam.core.common"
}

dependencies {
    implementation(libs.retrofit)
}