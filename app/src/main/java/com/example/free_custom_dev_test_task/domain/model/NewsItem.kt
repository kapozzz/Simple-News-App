package com.example.free_custom_dev_test_task.domain.model

import com.example.free_custom_dev_test_task.data.remote.dto.Type

data class NewsItem (
    val dateTimestamp: Long,
    val description: String,
    val endDateTimestamp: Long,
    val startDateTimestamp: Long,
    val tags: List<String>,
    val title: String,
    val type: Type,
    val url: String
)