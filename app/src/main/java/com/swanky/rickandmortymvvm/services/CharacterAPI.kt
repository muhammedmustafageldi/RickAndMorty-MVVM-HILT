package com.swanky.rickandmortymvvm.services

import com.swanky.rickandmortymvvm.models.ApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {

    @GET("api/character")
    fun getCharacters(@Query("page") page: Int): Single<ApiResponse>

}