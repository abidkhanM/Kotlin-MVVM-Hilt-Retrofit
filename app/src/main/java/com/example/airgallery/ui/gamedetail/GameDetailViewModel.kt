package com.example.airgallery.ui.gamedetail

import android.os.Bundle
import androidx.databinding.Observable
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airgallery.data.GameDetailModel
import com.example.airgallery.data.GameList
import kotlinx.coroutines.flow.collect
import com.example.airgallery.repository.GameRepository
import com.example.airgallery.utils.Constants
import com.example.airgallery.utils.Resource
import kotlinx.coroutines.launch


class GameDetailViewModel @ViewModelInject constructor(private val gameRepository: GameRepository,
                                                       @Assisted private val savedStateHandle: SavedStateHandle) :
    ViewModel(), Observable {

    private val _gameDetails = MutableLiveData<Resource<GameDetailModel>>()
    val gameDetails = _gameDetails
    private var id: Int? = null
    init {
        id = savedStateHandle.get("gameId")
        fetchImages()
    }


    private fun fetchImages() {
        viewModelScope.launch {

            // To get all the values in the stream as they're emitted by Flow from network repository, we use collect
            // collect is a suspend function, which needs to be executed using coroutine
            // The coroutine is suspended until the flow is closed
            gameRepository.getGameDetail(Constants.RAWG_API_KEY, id!!).collect {
                _gameDetails.value = it
            }
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) = Unit

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) = Unit
}
