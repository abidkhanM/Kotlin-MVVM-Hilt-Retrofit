package com.example.mvvm.datasources

import com.example.mvvm.base.BaseResponse
import com.example.mvvm.network.GameAPIsService
import javax.inject.Inject


/*
*
* Gets Retrofit Response, encapsulate in Resource for getting API statuses like error or success
* Just to get the status of an API response in a better way
* */
class GameRemoteDataSource @Inject constructor(
    private val _Game_APIsService: GameAPIsService
): BaseResponse() {

    /*
    * suspend is a kotlin coroutine modifier. When put with a function it shows that this code block will run in a coroutine a separate thread
    * and UI related operations can be performed during this execution. Long running operations like getting data from network can be fetch using this
    * */
    suspend fun getListDataOfGames(apiKey: String, pageSize: Int, pageNumber: Int) = getResult { _Game_APIsService.getListOfGames(apiKey, pageSize, pageNumber) }
    suspend fun getDetailsOfGame(apiKey: String, gameId: Int) = getResult { _Game_APIsService.getDetailsOfGame(gameId, apiKey) }
}