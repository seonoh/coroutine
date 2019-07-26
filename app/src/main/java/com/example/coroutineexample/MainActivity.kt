package com.example.coroutineexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Runnable
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),CoroutineScope {


    // Job을 등록할 수 있도록 초기화
    // CoroutineScope의 동작을 제어할 객체
    // 안드로이드 상에서는 Lifecycle을 활용할 수 있도록 도와준다.
    lateinit var job : Job


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = Job()

        CoroutineScope(coroutineContext)
    }

    // 작업 중이던 모든 job, children을 종료 처리
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}
