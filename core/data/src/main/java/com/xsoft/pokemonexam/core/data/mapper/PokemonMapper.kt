package com.xsoft.pokemonexam.core.data.mapper

import com.xsoft.pokemonexam.core.model.PokemonDetail
import com.xsoft.pokemonexam.core.model.Sprites
import com.xsoft.pokemonexam.core.model.Type
import com.xsoft.pokemonexam.core.model.TypeX
import com.xsoftcdmx.datastore.model.ResultEntity
import com.xsoftcdmx.network.model.NetworkResult
import com.xsoftcdmx.network.model.detail.NetworkPokemonDetail
import com.xsoftcdmx.network.model.detail.NetworkSprites
import com.xsoftcdmx.network.model.detail.NetworkType
import com.xsoftcdmx.network.model.detail.NetworkTypeX

fun NetworkResult.asEntity() = ResultEntity(
    id = pokemonId(),
    name = name,
    url = url,
    isFavorite = false
)

fun NetworkTypeX.asUiModel() = TypeX(
    name = name,
    url = url
)

fun NetworkType.asUi() = Type(
    slot = slot,
    type = type!!.asUiModel()
)


fun NetworkSprites.toSprites(): Sprites {
    return Sprites(
        back_default = this.backDefault,
        back_female = this.backFemale,
        back_shiny = this.backShiny,
        back_shiny_female = this.backShinyFemale,
        front_default = this.frontDefault,
        front_female = this.frontFemale,
        front_shiny = this.frontShiny,
        front_shiny_female = this.frontShinyFemale
    )
}

fun NetworkPokemonDetail.toPokemonDetailUi(): PokemonDetail {
    return PokemonDetail(
        id = this.id,
        height = this.height,
        name = this.name,
        order = this.order,
        weight = this.weight,
        sprites = this.sprites?.toSprites(),
        types = types?.map { it.asUi() }
    )
}