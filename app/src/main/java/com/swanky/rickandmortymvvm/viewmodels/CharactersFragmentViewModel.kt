package com.swanky.rickandmortymvvm.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.swanky.rickandmortymvvm.models.Character
import com.swanky.rickandmortymvvm.repo.CharacterRepository
import com.swanky.rickandmortymvvm.services.CustomSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersFragmentViewModel @Inject constructor(private val repository: CharacterRepository, application: Application) :
    BaseViewModel(application) {

    val charactersLiveData = MutableLiveData<List<Character>>()
    val errorLiveData = MutableLiveData<String>()
    val pageNumber = MutableLiveData<Int>()

    private val disposable = CompositeDisposable()
    private val customPreferences = CustomSharedPreferences.getInstance(getApplication())

    fun getCharacters() {
        val updateTime = customPreferences.getTime()

        // Check if data is older than 10 minutes
        if (updateTime != null && updateTime != 0L && System.currentTimeMillis() - updateTime < 10 * 60 * 1000) {
            fetchCharactersFromDB()
        } else {
            fetchCharactersFromApi()
        }
    }

    fun refreshCharacters() {
        fetchCharactersFromApi()
    }

    // Function to pull data from the API
    private fun fetchCharactersFromApi() {
        createRandomPageNumber()
        disposable.add(
            repository.getCharactersFromApi(page = pageNumber.value!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { apiResponse ->
                        val characters = apiResponse.results
                        charactersLiveData.postValue(characters)
                        // Save data from API to Room
                        viewModelScope.launch {
                            repository.deleteAllCharactersFromDB()
                            repository.saveCharactersToDB(characters)
                            // Save update time
                            customPreferences.saveTime(System.currentTimeMillis())
                        }
                    },
                    { error ->
                        errorLiveData.postValue(error.message)
                        println(error.message)
                    }
                )
        )
    }

    // Function to pull data from Room
    private fun fetchCharactersFromDB() {
        viewModelScope.launch {
            val characters = repository.getCharactersFromDB()
            if (characters.isNotEmpty()) {
                charactersLiveData.postValue(characters)
            }else{
                errorLiveData.postValue("No data found")
            }
        }
    }

    private fun createRandomPageNumber() {
        pageNumber.value = (1..42).random()
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}