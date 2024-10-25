package com.xsoftcdmx.list_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.xsoft.pokemonexam.core.common.Resource
import com.xsoft.pokemonexam.core.common.map
import com.xsoft.pokemonexam.core.data.mapper.toPokemonDetailUi
import com.xsoft.pokemonexam.core.data.repository.PokemonRepositoryImpl
import com.xsoft.pokemonexam.core.model.PokemonDetail
import com.xsoft.pokemonexam.core.model.ResultUiModel
import com.xsoftcdmx.datastore.model.ResultEntity
import com.xsoftcdmx.domain.mapper.asUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    pager: Pager<Int, ResultEntity>,
    private val repository: PokemonRepositoryImpl
) : ViewModel() {

    val pokemonPagingFlow = pager.flow
        .map { pagingData -> pagingData.map { it.asUiModel() } }
        .cachedIn(viewModelScope)

    private val _pokemonDetailState =
        MutableStateFlow<Resource<PokemonDetail>>(Resource.Loading)
    val pokemonDetailState: StateFlow<Resource<PokemonDetail>> =
        _pokemonDetailState.asStateFlow()

    private val _uiState = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState

    fun toggleFavorite(pokemon: ResultUiModel) {
        viewModelScope.launch {
            repository.toggleFavorite(pokemon.id, !pokemon.isFavorite)
            _uiState.value = if (pokemon.isFavorite) {
                "${pokemon.name} Eliminado de favoritos"
            } else {
                "${pokemon.name} Agregado a favoritos"
            }
        }
    }

    fun getPokemonDetail(id: Int) {
        viewModelScope.launch {
            repository.getPokemonDetail(id)
                .collect { resource ->
                    val mappedResource = resource.map { it.toPokemonDetailUi() }
                    _pokemonDetailState.value = mappedResource
                }
        }
    }

    fun clearUiState() {
        _uiState.value = ""
    }
}