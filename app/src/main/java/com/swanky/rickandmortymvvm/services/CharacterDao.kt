package com.swanky.rickandmortymvvm.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.swanky.rickandmortymvvm.models.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM Character")
    suspend fun getAllCharacters(): List<Character>

    @Query("SELECT * FROM Character WHERE id = :characterId")
    suspend fun getCharacterById(characterId: Int): Character

    @Insert
    suspend fun insertCharacters(characters: List<Character>)

    @Query("DELETE FROM Character")
    suspend fun deleteAllCharacters()


}