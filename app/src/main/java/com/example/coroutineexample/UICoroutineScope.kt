//package com.example.coroutineexample
//
//
//class UICoroutineScope(private val dispatchers: CoroutineContext = DispatchersProvider.main) : BaseCoroutineScope {
//
//    override val job: Job = Job()
//
//    override val coroutineContext: CoroutineContext
//        get() = dispatchers + job
//
//    override fun releaseCoroutine() {
//        if (DEBUG) {
//            Log.d("UICoroutineScope", "onRelease coroutine")
//        }
//        job.cancel()
//    }
//}