package com.decagon.n26_p6.core.data.network

import com.decagon.n26_p6.core.domain.data.raw.DataRaw
import retrofit2.Response

interface ApiService {
    suspend fun getData() : Response<DataRaw>
}