package com.example.free_custom_dev_test_task.di

import com.example.free_custom_dev_test_task.data.remote.ByBitApi
import com.example.free_custom_dev_test_task.data.repository.NewsItemRepositoryImpl
import com.example.free_custom_dev_test_task.domain.repository.NewsItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideByBitApi(): ByBitApi {
        return Retrofit.Builder()
            .baseUrl("https://api.bybit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ByBitApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: ByBitApi): NewsItemsRepository {
        return NewsItemRepositoryImpl(api)
    }

}