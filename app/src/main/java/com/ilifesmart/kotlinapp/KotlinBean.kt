package com.ilifesmart.kotlinapp

import android.os.Handler
import android.os.Looper
class KotlinBean: IBean {

    val runnable = Runnable { println("HAHAHHAAHHA") }
    var handler = Handler(Looper.getMainLooper())

    override fun postponeComputation(delay: Long, computation: Runnable?) {
        handler.postDelayed(runnable, delay)
    }

    // 单实例
    fun handleComputation() {
        postponeComputation(100, runnable)
    }

    // 每次创建实例
    fun handleComputation(value:Long) {
        postponeComputation(100) { println("value:$value") }
    }

    // 不适用传递的变量，则仅适用一个Runable实例。反之，则每次创建新的实例
    // KotlinBean().postponeComputation(100){ println("HAHAHAHAHAHAH") }  // 单实例

}