package com.example.lab2_fundamentals

import java.util.Scanner

fun main(args: Array<String>) {
    val arrayOfCars = arrayOf("MccLaren", "BMW" , "Toyota" , "Mercedes")
    val listOfCars = mutableListOf("MccLaren", "BMW" , "Toyota" , "Mercedes")
    val setOfCars = mutableSetOf("MccLaren", "BMW" , "Toyota" , "Mercedes","MccLaren", "BMW" , "Toyota" , "Mercedes")
    val mapOfCars = mutableMapOf("M" to "MccLaren", "B" to "BMW" , 1 to "One" )

    listOfCars.add("Dodge")

    mapOfCars["Z"] = "new Element"

    println(arrayOfCars[1])
    println(mapOfCars[1])
    println(mapOfCars["M"])


    println(listOfCars)
    println(setOfCars)
}
/*
 //    when
    val day = 'c'
    val dayOfWeek = when (day){
//        in 'a'..'d' -> 2
        in 'a'..'d' -> 2
        'f' -> 3
        else -> "Please enter a valid day"
    }

    println("Day of the week of $day is $dayOfWeek")
 println("Hello")
how to declare variables

    var age = 20
    val height = 2

read and write on the screen
    println("Enter your name")
    var name = readlnOrNull()
    name = null

    println("Your name is $name")
    if(name != null)
        println(name.length)

    println(
        """
        Your name is $name
        The length of your name is ${name?.length}
        Your age is $age
        Your height is $height
    """.trimIndent()
    )


    val canOrNot = if (age > 18) {
        "You are allowed to vote"
    }
    else if(age > 16)
        "You are very close"
    else
        "Come back when you are older"

    println(canOrNot)


*/


