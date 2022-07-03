package com.example.mvvm.ui.gallery

import androidx.databinding.Observable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.GameList
import kotlinx.coroutines.flow.collect
import com.example.mvvm.repository.GameRepository
import com.example.mvvm.utils.Constants
import com.example.mvvm.utils.Resource
import kotlinx.coroutines.launch


class GameViewModel @ViewModelInject constructor(private val gameRepository: GameRepository) :
    ViewModel(), Observable {

    private val _gamesList = MutableLiveData<Resource<GameList>>()
    val gamesList = _gamesList

    init {
        fetchImages()
    }


    private fun fetchImages() {
        viewModelScope.launch {

            // To get all the values in the stream as they're emitted by Flow from network repository, we use collect
            // collect is a suspend function, which needs to be executed using coroutine
            // The coroutine is suspended until the flow is closed
            gameRepository.getGames(Constants.RAWG_API_KEY, 50, 1).collect {
                _gamesList.value = it
            }
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) = Unit

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) = Unit
}
