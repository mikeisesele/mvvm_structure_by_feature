package com.decagon.n26_p6.features.usecase.implementation

import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.features.model.data.DataSafe
import com.decagon.n26_p6.features.model.data.toDataSafe
import com.decagon.n26_p6.features.repository.contracts.DataRepository
import com.decagon.n26_p6.features.usecase.contracts.IGetDataUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(private val repository: DataRepository): IGetDataUseCase {
    override operator fun invoke(): Flow<Resource<DataSafe>> = flow{
        emit (
            try {
                val response = repository.getData()
                val result = response.body()

                if (response.isSuccessful && result != null){
                    Resource.Success(result.toDataSafe())
                } else {
                    Resource.Error(response.message())
                }

            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        )
    }
}