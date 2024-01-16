package com.example.free_custom_dev_test_task.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.free_custom_dev_test_task.presentation.components.NewsItemCard

@Composable
fun NewsScreen(
    state: NewsScreenState
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state.currentScreen.value) {
            ScreenState.DataIsLoaded -> {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(
                        state.news,
                        key = { item ->
                            item.url
                        }
                    ) { item ->
                        NewsItemCard(
                            newsItem = item
                        )
                    }
                }

            }

            ScreenState.Loading -> {
                CircularProgressIndicator()
            }

            ScreenState.Error -> {
                Text(text = "Error :(")
            }
        }
    }

}