package com.example.free_custom_dev_test_task.domain.repository

import com.example.free_custom_dev_test_task.domain.model.NewsItem
import com.example.free_custom_dev_test_task.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface NewsItemsRepository {

    fun getNews(): Flow<Resource<List<NewsItem>>>

}