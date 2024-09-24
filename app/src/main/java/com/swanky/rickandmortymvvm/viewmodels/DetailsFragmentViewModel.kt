package com.swanky.rickandmortymvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swanky.rickandmortymvvm.models.Character
import com.swanky.rickandmortymvvm.repo.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsFragmentViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {

    val characterLiveData = MutableLiveData<Character>()

    fun getCharacterById(characterId: Int) {
        viewModelScope.launch {
            val character = repository.getCharacterByIdFromDB(characterId)
            characterLiveData.postValue(character)
        }
    }

}