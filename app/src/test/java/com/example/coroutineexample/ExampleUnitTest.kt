package com.example.coroutineexample

import android.util.Log
import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*
import java.lang.Runnable

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun startThread(){
        Thread(Runnable {
            for (i in 1 .. 10){
                Thread.sleep(1000L)
                Log.e("thread","thread is working")
            }
        }).start()
    }

    @Test
    fun startCoroutine(){GlobalScope.launch(Dispatchers.Default){
            repeat(10){
                kotlinx.coroutines.delay(1000L)
                Log.e("coroutine","coroutine is working")
            }
        }
    }

    @Test
    fun testJob() = runBlocking {
        val job = Job()
        CoroutineScope(Dispatchers.Default + job).launch {

            CoroutineScope(Dispatchers.Default).launch {
                println("Job one scope start")
                for (index in 0..20) {
                    if (isActive) {
                        println("Job one scope index $index")
                        delay(1)
                    } else {
                        break
                    }
                }
                println("Job one scope for end")
            }


            val jobTwo = launch {
                println("Job two scope for start")
                for (index in 0..20) {
                    if (isActive) {
                        println("Job two scope index $index")
                        delay(1)
                    } else {
                        break
                    }
                }
                println("Job two scope for end")
            }


            jobTwo.join()
        }

        job.cancel()
        delay(30) // 30ms test only.
    }
}
