package com.swanky.rickandmortymvvm.services

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharedPreferences {

    companion object {

        private var sharedPreferences: SharedPreferences? = null

        @Volatile private var instance: CustomSharedPreferences? = null
        private val lock = Any()

        fun getInstance(context: Context) : CustomSharedPreferences = instance ?: synchronized(lock){
            makeCustomSharedPreferences(context).also {
                instance = it
            }
        }

        private fun makeCustomSharedPreferences(context: Context): CustomSharedPreferences{
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }

    }

    fun saveTime(time: Long){
        sharedPreferences?.edit(commit = true){
            putLong("time", time)
        }
    }

    fun getTime() = sharedPreferences?.getLong("time", 0)

}