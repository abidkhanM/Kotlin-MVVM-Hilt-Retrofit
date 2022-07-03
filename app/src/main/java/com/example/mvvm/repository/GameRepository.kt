package com.example.mvvm.repository

import com.example.mvvm.data.GameDetailModel
import com.example.mvvm.data.GameList
import com.example.mvvm.datasources.GameRemoteDataSource
import com.example.mvvm.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val gameRemoteDataDataSource: GameRemoteDataSource
) {


    /*
    * Flow used to emit multiple values sequentially
    * Checkout this for better understanding https://developer.android.com/kotlin/flow
    *
      There are 3 entities are involved in stream of data by flow
      1- A producer produces data that is added to the stream. Thanks to coroutines, flows can also produce data asynchronously. In our Case RemoteDataSource

      2- (Optional) Intermediaries can modify each value emitted into the stream or the stream itself. It performs operations on data and using flow emits
         which then collected by consumer. In our case dataSources, Network Repositories

      3- A consumer consumes the values from the stream. In Our cases ViewModels

    * */
    /*
       * suspend is a kotlin coroutine modifier. When put with a function it shows that this code block will run in a coroutine a separate thread
       * and UI related operations can be performed during this execution. Long running operations like getting data from network can be fetch using this
       *
       * Suspend compare to flow returns single value
       * */

    // to get games
    suspend fun getGames(apiKey: String, pageSize: Int, pageNumber: Int): Flow<Resource<GameList>?> {
        return flow {
            emit(Resource.loading())
            val result = gameRemoteDataDataSource.getListDataOfGames(apiKey, pageSize, pageNumber)


            /*if (result.status == Resource.Status.SUCCESS) {
                result.data?.results?.let { it ->
                    // Save Data if required
                }
            }*/
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGameDetail(apiKey: String, gameId: Int): Flow<Resource<GameDetailModel>?> {
        return flow {
            emit(Resource.loading())
            val result = gameRemoteDataDataSource.getDetailsOfGame(apiKey, gameId)


            /*if (result.status == Resource.Status.SUCCESS) {
                result.data?.results?.let { it ->
                    // Save Data if required
                }
            }*/
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}