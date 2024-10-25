package com.xsoftcdmx.list_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.xsoft.pokemonexam.core.common.Resource
import com.xsoft.pokemonexam.core.model.PokemonDetail
import com.xsoftcdmx.designsystem.components.rememberDominantColorFromImage
import com.xsoftcdmx.list_detail.composable.ErrorScreen
import com.xsoftcdmx.list_detail.composable.ModalBottomSheetContent
import kotlinx.coroutines.launch

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    onPokemonClick: Int,
    mViewModel: PokemonViewModel = hiltViewModel()
) {
    LaunchedEffect(onPokemonClick) {
        mViewModel.getPokemonDetail(onPokemonClick)
    }
    GetDetailPokemon()

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDetailPokemon(
    modifier: Modifier = Modifier,
    mViewModel: PokemonViewModel = hiltViewModel()
) {
    val pokemonDetailState by mViewModel.pokemonDetailState.collectAsState()
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Expanded
        )
    )

    val uiState = mViewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(uiState) {
        if (uiState.value.isNotEmpty()) {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(uiState.value)
                mViewModel.clearUiState()
            }
        }
    }
    LaunchedEffect(sheetState.bottomSheetState.currentValue) {
        if (sheetState.bottomSheetState.currentValue == SheetValue.Hidden) {
            coroutineScope.launch {
                sheetState.bottomSheetState.expand()
            }
        }
    }

    when (pokemonDetailState) {
        is Resource.Loading -> {
            LinearProgressIndicator(modifier = modifier.fillMaxWidth())
        }

        is Resource.Success -> {
            val pokemonDetail = (pokemonDetailState as Resource.Success<PokemonDetail>).data
            val backgroundColor = rememberDominantColorFromImage(pokemonDetail.pathSprite())
            BottomSheetScaffold(
                modifier = modifier.windowInsetsPadding(WindowInsets.navigationBars),
                sheetSwipeEnabled = false,
                scaffoldState = sheetState,
                sheetContainerColor = MaterialTheme.colorScheme.surface,
                sheetContent = {
                    ModalBottomSheetContent(itemData = pokemonDetail, titleColor = backgroundColor)
                },
                containerColor = backgroundColor
            ) {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(pokemonDetail.pathSprite())
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )
                }
            }
        }

        is Resource.Failure -> {
            ErrorScreen()
        }
    }
}

