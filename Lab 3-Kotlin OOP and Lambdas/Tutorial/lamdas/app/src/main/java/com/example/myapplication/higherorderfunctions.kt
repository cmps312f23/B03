package com.example.myapplication

fun main() {
    println(isEven(22))

    genericFunction(fun(number: Int) = number % 2 == 0)

    genericFunction { number: Int -> number % 2 == 0 }
    genericFunction2(10) { number: Int -> number % 2 == 0 }

    genericFunction(isEven)
    genericFunction(isEven2)
//    genericFunction(isOdd)

    genericFunction(::isNeg)

    val a = 10
    val b = 20

    add(a, b)
    add(10, 20)
}

fun genericFunction(predicate: (Int) -> Boolean) {
    for (i in 1..100) {
        if (predicate(i))
            print("$i ")
    }
    println()
}

fun genericFunction2(a : Int , predicate: (Int) -> Boolean) {
    for (i in 1..100) {
        if (predicate(i))
            print("$i ")
    }
    println()
}

fun add(x: Int, y: Int): Int {
    return x + y
}

val isEven = fun(number: Int) = number % 2 == 0

val isEven2 = { number: Int -> number % 2 == 0 }

val isOdd = fun(number: Int) = number % 2 != 0

fun isNeg(number: Int): Boolean {
    return number < 0
}
