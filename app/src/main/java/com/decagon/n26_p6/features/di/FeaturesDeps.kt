package com.decagon.n26_p6.features.di

import com.decagon.n26_p6.core.data.network.ApiService
import com.decagon.n26_p6.features.repository.contracts.DataRepository
import com.decagon.n26_p6.features.repository.implementations.DataRepositoryImpl
import com.decagon.n26_p6.features.usecase.contracts.IGetDataUseCase
import com.decagon.n26_p6.features.usecase.implementation.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeaturesDeps {

    @Provides
    @Singleton
    fun providesRepository(apiService: ApiService): DataRepository {
        return DataRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesUsecase(repository: DataRepository) : IGetDataUseCase {
        return GetDataUseCase(repository)
    }
}