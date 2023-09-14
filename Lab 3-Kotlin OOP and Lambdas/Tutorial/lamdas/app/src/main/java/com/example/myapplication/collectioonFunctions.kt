package com.example.myapplication

fun main(args: Array<String>) {
    val numbers  = listOf(1,-12,3,-14,5,6,-17,81,-19,10)
    val listOfNames = listOf("Johnas","Ja","Jakey", "Abdulahi", "Wardan")

    val urls = listOf<String>("www.naver.com","www.daum.net","www.google.com")
    numbers.forEach { number: Int -> print("$number ") }
    numbers.forEach { print("$it ") }
    println()

    val times10 = numbers.map { "hello ${it * 10}"}
    println(numbers)
    println(times10)

    val namesWithLength =  listOfNames.map {"$it - ${it.length}"}
    println(namesWithLength)

    println()
//    finding specific element in the list

    val firstElementInLis =  listOfNames.find { it == "JXa" }
    println(firstElementInLis)

    val namesStartWithJ = listOfNames.filter { it.startsWith("J")
}