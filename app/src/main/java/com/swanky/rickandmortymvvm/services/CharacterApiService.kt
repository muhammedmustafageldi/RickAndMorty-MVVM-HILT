package com.swanky.rickandmortymvvm.services

import javax.inject.Inject

class CharacterApiService @Inject constructor(private val api: CharacterAPI) {

    fun getCharacters(page: Int) = api.getCharacters(page)
}