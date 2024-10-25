import com.xsoft.pokemonexam.build_logic.convention.implementation
import com.xsoft.pokemonexam.build_logic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("pokemonexam.android.library")
                apply("pokemonexam.android.library.compose")
                apply("pokemonexam.android.hilt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                implementation(project(":core:domain"))
                implementation(project(":core:data"))
                implementation(project(":core:datastore"))
                implementation(project(":core:model"))
                implementation(project(":core:network"))

                // Define common dependencies for feature modules
                implementation(libs.findLibrary("androidx-navigation-compose").get())
                implementation(libs.findLibrary("kotlinx-serialization-json").get())
            }
        }
    }
}
