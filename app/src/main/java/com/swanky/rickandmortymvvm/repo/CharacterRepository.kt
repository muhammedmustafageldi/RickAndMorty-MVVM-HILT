package com.swanky.rickandmortymvvm.repo

import com.swanky.rickandmortymvvm.models.ApiResponse
import com.swanky.rickandmortymvvm.models.Character
import com.swanky.rickandmortymvvm.services.CharacterApiService
import com.swanky.rickandmortymvvm.services.CharacterDao
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: CharacterApiService,
    private val characterDao: CharacterDao
) {

    // Pull data from API
    fun getCharactersFromApi(page: Int): Single<ApiResponse> {
        return apiService.getCharacters(page)
    }


    // Pull data from Room
    suspend fun getCharactersFromDB(): List<Character>{
        return withContext(Dispatchers.IO){
            characterDao.getAllCharacters()
        }
    }

    // Get character by id from db
    suspend fun getCharacterByIdFromDB(characterId: Int): Character{
        return withContext(Dispatchers.IO){
            characterDao.getCharacterById(characterId)
        }
    }

    //Save characters to db
    suspend fun saveCharactersToDB(characters: List<Character>){
        withContext(Dispatchers.IO){
            characterDao.insertCharacters(characters)
        }
    }

    // Delete characters from db
    suspend fun deleteAllCharactersFromDB(){
        withContext(Dispatchers.IO){
            characterDao.deleteAllCharacters()
        }
    }

}