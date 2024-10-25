import com.xsoft.pokemonexam.build_logic.convention.implementation

plugins {
    alias(libs.plugins.pokemonexam.android.application)
    alias(libs.plugins.pokemonexam.android.application.compose)
    alias(libs.plugins.pokemonexam.android.hilt)
}

android {
    namespace = "com.xsoft.pokemonexam"

    defaultConfig {
        applicationId = "com.xsoft.pokemonexam"
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildFeatures {
            buildConfig = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }

}

dependencies {
    implementation(projects.feature.listDetail)
    implementation(libs.androidx.navigation.compose)
    implementation(project(":core:designsystem"))
}
