package com.decagon.n26_p6.features.jokes.di

import com.decagon.n26_p6.common.utils.Constants.JOKES_BASE_URL
import com.decagon.n26_p6.features.jokes.data.remote.JokesApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Network {

    //provide gson converter
    @Provides
    @Singleton
    fun provideGsonConverter() : Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(converter: Converter.Factory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(JOKES_BASE_URL)
            .addConverterFactory(converter)
            .build()
    }


    @Provides
    @Singleton
    fun provideJokesApi(retrofit: Retrofit) : JokesApiInterface {
        return retrofit.create(JokesApiInterface::class.java)
    }

}