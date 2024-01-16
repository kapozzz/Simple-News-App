package com.example.free_custom_dev_test_task.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.free_custom_dev_test_task.domain.model.NewsItem


data class NewsScreenState(
    val news: MutableList<NewsItem> = mutableListOf(),
    val currentScreen: MutableState<ScreenState> = mutableStateOf(ScreenState.Loading)
)

sealed class ScreenState() {

    object Loading: ScreenState()

    object DataIsLoaded: ScreenState()

    object Error: ScreenState()

}