package com.decagon.n26_p6.features.jokes.di

import com.decagon.n26_p6.features.jokes.data.remote.JokesApiInterface
import com.decagon.n26_p6.features.jokes.repository.JokesRepository
import com.decagon.n26_p6.features.jokes.repository.JokesRepositoryRetrofitImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object JokesDepencencies  {

    @Provides
    @Singleton
    fun provideJokeRepository(jokesApiInterface: JokesApiInterface): JokesRepositoryRetrofitImpl {
        return JokesRepositoryRetrofitImpl(jokesApiInterface)
    }

}