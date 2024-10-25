package com.xsoftcdmx.network.api

import com.xsoftcdmx.network.model.NetworkPokemonRs
import com.xsoftcdmx.network.model.NetworkResult
import com.xsoftcdmx.network.model.detail.NetworkPokemonDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiPokemon {
    @GET("pokemon")
    suspend fun getPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<NetworkPokemonRs>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): Response<NetworkPokemonDetail>
}
