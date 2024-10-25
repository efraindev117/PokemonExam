import com.xsoft.pokemonexam.build_logic.convention.implementation

plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.pokemonexam.android.feature)
    alias(libs.plugins.pokemonexam.android.hilt)
}

android {
    namespace = "com.xsoftcdmx.list_detail"

}

dependencies {
    // Paging
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(libs.androidx.palette)
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose.v100alpha18)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.coil)
    implementation(libs.coil.compose.v222)
    implementation (libs.androidx.material3)
    implementation(libs.material)

}