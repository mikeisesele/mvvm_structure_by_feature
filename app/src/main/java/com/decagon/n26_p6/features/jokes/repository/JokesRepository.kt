package com.decagon.n26_p6.features.jokes.repository

import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.features.jokes.model.JokesResponseClass
import com.decagon.n26_p6.features.jokes.model.JokesString
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface JokesRepository {

    suspend fun getProgrammingJokesData(): Flow<Resource<JokesString>>
    suspend fun getAnyJokesAny(): Resource<JokesString>

}