package com.decagon.n26_p6.features.model.data

import com.decagon.n26_p6.core.domain.data.raw.DataRaw

data class DataSafe (
    val id : String
        )



fun DataRaw.toDataSafe() : DataSafe {
    return DataSafe (
        id = id
            )
}
