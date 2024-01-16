package com.example.free_custom_dev_test_task.data.remote.dto

import com.example.free_custom_dev_test_task.domain.model.NewsItem

data class Result(
    val list: List<NewsItem>,
    val total: Int
)