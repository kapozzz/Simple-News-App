package com.example.free_custom_dev_test_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.free_custom_dev_test_task.presentation.NewsScreen
import com.example.free_custom_dev_test_task.presentation.NewsScreenViewModel
import com.example.free_custom_dev_test_task.ui.theme.FreecustomdevtesttaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreecustomdevtesttaskTheme {

                val newsScreenViewModel: NewsScreenViewModel = hiltViewModel()

                NewsScreen(newsScreenViewModel.state.value)
            }
        }
    }
}
