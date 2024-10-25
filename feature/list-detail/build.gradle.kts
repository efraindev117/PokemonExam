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
    implementation("androidx.palette:palette:1.0.0")
    implementation("androidx.paging:paging-runtime-ktx:3.1.1")
    implementation("androidx.paging:paging-compose:1.0.0-alpha18")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("io.coil-kt:coil:2.2.2")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("androidx.palette:palette:1.0.0")
    implementation(project(":core:common"))
    implementation ("androidx.compose.material3:material3:1.3.0")
    implementation(libs.material)

    // Para extraer colores con Palette
}