package com.xsoftcdmx.list_detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.xsoft.pokemonexam.core.model.ResultUiModel
import com.xsoftcdmx.designsystem.R
import com.xsoftcdmx.list_detail.composable.PokemonItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreenContent(
    modifier: Modifier = Modifier,
    onPokemonClick: (Int) -> Unit,
    mViewModel: PokemonViewModel = hiltViewModel()
) {
    val pokemons = mViewModel.pokemonPagingFlow.collectAsLazyPagingItems()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(topBar = {
        TopAppBar(title = {
            Row {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.ic_pokemon),
                    contentDescription = stringResource(
                        id = R.string.image_description
                    )
                )
                Text(
                    modifier = modifier.padding(start = 8.dp),
                    text = "Pokémon"
                )
            }
        })
    }, snackbarHost = {
        SnackbarHost(hostState = snackBarHostState)
    }) { paddingValues ->
        PokemonListScreen(
            pokemons = pokemons, modifier = modifier.padding(paddingValues),
            state = snackBarHostState,
            onPokemonClick = onPokemonClick
        )
    }

}

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    pokemons: LazyPagingItems<ResultUiModel>,
    mViewModel: PokemonViewModel = hiltViewModel(),
    onPokemonClick: (Int) -> Unit,
    state: SnackbarHostState
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(pokemons.loadState) {
        if (pokemons.loadState.refresh is LoadState.Error) {
            Toast.makeText(context, "Ocurrio un error", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        if (pokemons.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    items = pokemons,
                    key = { it.id }
                ) { pokemon ->
                    if (pokemon != null) {
                        PokemonItem(
                            pokemonItem = pokemon,
                            onFavoriteClick = {
                                mViewModel.toggleFavorite(pokemon)
                                coroutineScope.launch {
                                    val message = if (pokemon.isFavorite) {
                                        "${pokemon.name} eliminado de favoritos".capitalizeFirstLetter()
                                    } else {
                                        "${pokemon.name} agregado a favoritos".capitalizeFirstLetter()
                                    }
                                    state.showSnackbar(message)
                                }
                            }, onPokemonClick = {
                                onPokemonClick(pokemon.id)
                            }
                        )
                    }
                }
                item {
                    if (pokemons.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

fun String.capitalizeFirstLetter(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}