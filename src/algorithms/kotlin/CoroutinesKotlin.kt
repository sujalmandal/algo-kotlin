package algorithms.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val routine = GlobalScope.launch {
        delay(100)
        println("Hi ${Thread.currentThread().name}")
    }
    println("Hi ${Thread.currentThread().name}")
    routine.join()
}