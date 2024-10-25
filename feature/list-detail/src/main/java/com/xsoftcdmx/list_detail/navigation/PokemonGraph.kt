package com.xsoftcdmx.list_detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xsoftcdmx.list_detail.PokemonDetailScreen
import com.xsoftcdmx.list_detail.PokemonListScreenContent

const val POKEMON_GRAPH_ROUTE = "pokemon_graph"
const val POKEMON_DETAIL_ROUTE = "pokemon_detail/{id}"

fun pokemonDetailRoute(id: Int) = "pokemon_detail/$id"

fun NavGraphBuilder.pokemonScreen(
    goToDetail: (Int) -> Unit,
) {
    composable(route = POKEMON_GRAPH_ROUTE) {
        PokemonListScreenContent(onPokemonClick = goToDetail)
    }

    composable(
        route = POKEMON_DETAIL_ROUTE,
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backStackEntry ->
        val pokemonId = backStackEntry.arguments?.getInt("id") ?: 0
        PokemonDetailScreen(onPokemonClick = pokemonId)
    }


}

