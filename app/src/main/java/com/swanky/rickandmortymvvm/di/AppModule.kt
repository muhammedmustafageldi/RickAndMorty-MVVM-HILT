package com.swanky.rickandmortymvvm.di

import android.content.Context
import androidx.room.Room
import com.swanky.rickandmortymvvm.services.CharacterAPI
import com.swanky.rickandmortymvvm.services.CharacterDao
import com.swanky.rickandmortymvvm.services.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterAPI{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(CharacterAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideCharacterDatabase(@ApplicationContext context: Context): CharacterDatabase{
        return Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "CharacterDatabase"
        ).build()
    }


    @Singleton
    @Provides
    fun providesCharacterDao(database: CharacterDatabase): CharacterDao {
        return database.characterDao()
    }


}