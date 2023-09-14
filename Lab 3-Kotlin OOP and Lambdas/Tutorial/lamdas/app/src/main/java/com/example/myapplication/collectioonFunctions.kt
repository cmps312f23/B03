package com.example.myapplication

fun main(args: Array<String>) {
    val numbers = listOf(1, -12, 3, -14, 5, 6, -17, 81, -19, 10)
    val listOfNames = listOf("Johnas", "Ja", "Jakey", "Abdulahi", "Wardan")

    val urls = listOf<String>("www.naver.com", "www.daum.net", "www.google.com")
    numbers.forEach { number: Int -> print("$number ") }
    numbers.forEach { print("$it ") }
    println()

    val times10 = numbers.map { "hello ${it * 10}" }
    println(numbers)
    println(times10)

    val namesWithLength = listOfNames.map { "$it - ${it.length}" }
    println(namesWithLength)

    println()
//    finding specific element in the list

    val firstElementInLis = listOfNames.find { it == "JXa" }
    println(firstElementInLis)

    val namesStartWithJ = listOfNames.filter { it.startsWith("J") }
    println(namesStartWithJ)

    println()
//        val numbers  = listOf(1,-12,3,-14,5,6,-17,81,-19,10)
    val total = numbers.reduce { acc: Int, nextValue: Int -> acc + nextValue }
    val total2 = numbers.fold(100) { acc: Int, nextValue: Int -> acc + nextValue }

    val mySort = numbers.sortedWith{ a:Int , b:Int -> a-b }


    println("Total $total")
    println("Sorted ${numbers.sorted()}")
    println("Sorted ${numbers.sortedDescending()}")
    println("Total2 $total2")
    println("Total2 ${numbers.fold(100) { acc: Int, nextValue: Int -> acc + nextValue }}")



//     acc = 1 and nextValue = -12
//    acc = -11 and nextValue = 3
//    acc = -8 and nextValue = -14
//    acc  = -22 and nextValue = 5
//    acc = -17 and nextValue = 6
}