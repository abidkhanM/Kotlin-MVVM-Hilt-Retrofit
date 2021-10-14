package com.example.airgallery.network

import com.example.airgallery.data.GameDetailModel
import com.example.airgallery.data.GameList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/*
* Interface for Retrofit that get methods with end points and the data and returns results of WebAPI
*
*  USED BY REMOTE DATA SOURCE
* */
interface GameAPIsService {
    /*
   * suspend is a kotlin coroutine modifier. When put with a function it shows that this code block will run in a coroutine a separate thread
   * and UI related operations can be performed during this execution. Long running operations like getting data from network can be fetch using this
   * */

    @GET("games")
    suspend fun getListOfGames(@Query("key") key: String, @Query("page_size") pageSize: Int,
                               @Query("page") page: Int) : Response<GameList>

    @GET("games/{id}")
    suspend fun getDetailsOfGame(@Path("id") id: Int, @Query("key") key: String) : Response<GameDetailModel>
}