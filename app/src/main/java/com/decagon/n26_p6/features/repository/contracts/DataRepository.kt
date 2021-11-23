package com.decagon.n26_p6.features.repository.contracts

import com.decagon.n26_p6.core.domain.data.raw.DataRaw
import retrofit2.Response

interface DataRepository {
    suspend fun getData() : Response<DataRaw>
}