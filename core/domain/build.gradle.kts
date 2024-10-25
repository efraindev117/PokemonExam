plugins {
    alias(libs.plugins.pokemonexam.android.library)
}

android {
    namespace = "com.xsoftcdmx.domain"
}

dependencies {
    implementation(project(":core:datastore"))
    implementation(project(":core:model"))

}