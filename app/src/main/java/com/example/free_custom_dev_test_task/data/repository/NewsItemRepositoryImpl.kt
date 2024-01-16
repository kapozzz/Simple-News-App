package com.example.free_custom_dev_test_task.data.repository

import android.util.Log
import com.example.free_custom_dev_test_task.data.remote.ByBitApi
import com.example.free_custom_dev_test_task.domain.model.NewsItem
import com.example.free_custom_dev_test_task.domain.model.Resource
import com.example.free_custom_dev_test_task.domain.repository.NewsItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsItemRepositoryImpl (
    private val api: ByBitApi
): NewsItemsRepository {

    override fun getNews(): Flow<Resource<List<NewsItem>>>  = flow {
        try {
            emit(Resource.Loading())
            val news = api.getItems().result.list
            emit(Resource.Success(news))
        } catch(e: Throwable) {
            Log.i("RETROFIT LOG", "error")
            emit(Resource.Failure(e.localizedMessage ?: "unexpected error"))
        }
    }
}