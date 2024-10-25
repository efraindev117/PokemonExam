package com.xsoftcdmx.domain.mapper

import com.xsoft.pokemonexam.core.model.ResultUiModel
import com.xsoftcdmx.datastore.model.ResultEntity


fun ResultEntity.asUiModel() = ResultUiModel(
    id, name, url, isFavorite
)