plugins {
    alias(libs.plugins.pokemonexam.android.library)
    alias(libs.plugins.secrets)
    
}

android {
    namespace = "com.xsoft.pokemonexam.core.model"
    buildFeatures {
        buildConfig = true
    }
}
secrets{
    defaultPropertiesFileName = "constants.properties"
}

dependencies {

}