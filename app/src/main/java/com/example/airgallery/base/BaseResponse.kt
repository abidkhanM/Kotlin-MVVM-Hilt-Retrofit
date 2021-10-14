package com.example.airgallery.base

import com.example.airgallery.utils.Resource
import retrofit2.Response
import timber.log.Timber


/*
* Using Resource helper class return success data or error with messages
* */
abstract class BaseResponse {

    /*
   * suspend is a kotlin coroutine modifier. When put with a function it shows that this code block will run in a coroutine a separate thread
   * and UI related operations can be performed during this execution. Long running operations like getting data from network can be fetch using this
   * */

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.d(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }

}