package com.swanky.rickandmortymvvm.services

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.swanky.rickandmortymvvm.models.Character
import com.swanky.rickandmortymvvm.utils.Converters

@Database(entities = [Character::class], version = 1)
@TypeConverters(Converters::class)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}