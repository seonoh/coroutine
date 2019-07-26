package com.example.coroutineexample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

interface BaseCoroutineScope : CoroutineScope{

    //coroutineScope 동작을 제어할 객체
    val job : Job

    fun releaseCoroutine()

}