plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.pokemonexam.android.hilt)
    alias(libs.plugins.pokemonexam.android.room)
}

android {
    namespace = "com.xsoftcdmx.datastore"
}

dependencies {
    implementation(libs.converter.gson)
    implementation(libs.room.paging)
    implementation(project(":core:model"))
}