package com.decagon.n26_p6.features.jokes.repository

import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.features.jokes.data.remote.JokesApiInterface
import com.decagon.n26_p6.features.jokes.model.JokesResponseClass
import com.decagon.n26_p6.features.jokes.model.JokesString
import com.decagon.n26_p6.features.jokes.model.toJokesString
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class JokesRepositoryRetrofitImpl @Inject constructor(private val jokesApiInterface: JokesApiInterface) : JokesRepository {

    override suspend fun getProgrammingJokesData(): Flow<Resource<JokesString>> =

        flow {
            emit(Resource.Loading("Loading"))
            try {
                val response =  jokesApiInterface.getProgrammingJokesData()
                val body = response.body()


                if (response.isSuccessful && body != null) {
                    emit(Resource.Success(body.toJokesString()))
                } else {
                    emit(Resource.Error(response.message()))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error Occurred"))
            }
        }





    override suspend fun getAnyJokesAny(): Resource<JokesString> {

        val response = jokesApiInterface.getAnyJokesAny()
        val body = response.body()

        if (response.isSuccessful && body != null) {
            return Resource.Success(body.toJokesString())
        } else {
            return Resource.Error(response.message())
        }

    }

}