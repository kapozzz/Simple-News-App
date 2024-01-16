package com.example.free_custom_dev_test_task.data.remote

import com.example.free_custom_dev_test_task.data.remote.dto.ByBitResult
import retrofit2.http.GET

interface ByBitApi {

    @GET("/v5/announcements/index?locale=en-US&limit=10")
    suspend fun getItems(): ByBitResult

}