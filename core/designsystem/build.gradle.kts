import com.xsoft.pokemonexam.build_logic.convention.implementation

plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.pokemonexam.android.feature)
}

android {
    namespace = "com.xsoftcdmx.designsystem"

}

dependencies {
    implementation(libs.coil.compose)
    implementation (libs.androidx.palette)
    implementation(libs.material.icons)
}