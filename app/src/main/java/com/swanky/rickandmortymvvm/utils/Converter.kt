package com.swanky.rickandmortymvvm.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swanky.rickandmortymvvm.models.Location

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromLocation(location: Location?): String? {
        return gson.toJson(location)
    }

    @TypeConverter
    fun toLocation(locationString: String?): Location? {
        val type = object : TypeToken<Location>() {}.type
        return gson.fromJson(locationString, type)
    }
}
