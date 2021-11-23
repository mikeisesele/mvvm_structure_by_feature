package com.decagon.n26_p6.features.usecase.contracts

import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.features.model.data.DataSafe
import kotlinx.coroutines.flow.Flow

interface IGetDataUseCase {
    operator fun invoke() : Flow<Resource<DataSafe>>
}