package com.cmps312.intro

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    helloWorld()
}

suspend fun helloWorld() = coroutineScope {
    for (i in 1.. 50000){
        launch { heavyWork(i) }
    }
}

suspend fun heavyWork(i : Int) {
    delay((1000..5000L).random())
    print("$i ")
}