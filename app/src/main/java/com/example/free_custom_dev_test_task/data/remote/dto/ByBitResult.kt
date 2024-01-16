package com.example.free_custom_dev_test_task.data.remote.dto

data class ByBitResult(
    val result: Result,
    val retCode: Int,
    val retExtInfo: RetExtInfo,
    val retMsg: String,
    val time: Long
)