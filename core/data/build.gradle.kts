plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.pokemonexam.android.hilt)
    alias(libs.plugins.pokemonexam.android.room)
}

android {
    namespace = "com.xsoft.pokemonexam.core.data"
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.room.paging)
    implementation(project(":core:network"))
    implementation(project(":core:datastore"))
    implementation(project(":core:common"))
    implementation(project(":core:model"))
}