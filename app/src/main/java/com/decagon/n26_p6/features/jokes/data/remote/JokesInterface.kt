package com.decagon.n26_p6.features.jokes.data.remote

import com.decagon.n26_p6.features.jokes.model.JokesResponseClass
import retrofit2.Response
import retrofit2.http.*


interface JokesApiInterface {

    @GET("Programming")
    suspend fun getProgrammingJokesData(): Response<JokesResponseClass>

    @GET("Any")
    suspend fun getAnyJokesAny(): Response<JokesResponseClass>

}