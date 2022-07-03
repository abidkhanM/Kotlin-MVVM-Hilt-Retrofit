package com.example.mvvm.utils


/*
* A helper class which helps in encapsulating repository responses based on response state (could be success/error)
* Also used in fragments to display values based on states
*
* Example
* A Fragment observing a LiveData object and updates it's views whatever API state is error or success.
* */

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}