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
    implementation ("androidx.palette:palette:1.0.0")
    implementation(libs.material.icons)
}