package com.example.free_custom_dev_test_task.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.free_custom_dev_test_task.domain.model.Resource
import com.example.free_custom_dev_test_task.domain.repository.NewsItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    repository: NewsItemsRepository
) : ViewModel() {

    private val _state: MutableState<NewsScreenState> = mutableStateOf(NewsScreenState())
    val state: State<NewsScreenState> = _state

    init {

        repository.getNews().onEach { resource ->
            when (resource) {

                is Resource.Failure -> {
                    state.value.currentScreen.value = ScreenState.Error
                }

                is Resource.Loading -> {
                    state.value.currentScreen.value = ScreenState.Loading
                }

                is Resource.Success -> {
                    _state.value.news.addAll(resource.data ?: emptyList())
                    state.value.currentScreen.value = ScreenState.DataIsLoaded
                }
            }
        }.launchIn(viewModelScope)
    }

}