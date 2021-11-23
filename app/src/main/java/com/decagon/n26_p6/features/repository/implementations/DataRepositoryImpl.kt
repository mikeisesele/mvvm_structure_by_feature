package com.decagon.n26_p6.features.repository.implementations

import com.decagon.n26_p6.core.data.network.ApiService
import com.decagon.n26_p6.core.domain.data.raw.DataRaw
import com.decagon.n26_p6.features.repository.contracts.DataRepository
import retrofit2.Response
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val apiService: ApiService) : DataRepository {
    override suspend fun getData(): Response<DataRaw> = apiService.getData()
}