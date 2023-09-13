package com.example.lab2_fundamentals

import java.util.Scanner

//fun main(args: Array<String>) {
//    val
//}


//data class Team(var name : String , var dateOfEst : Int , var noOfTrophies : Int){
//    fun exposeThePrivate(){
////        checking somethign
//        rerty
//    }
//}

//
////class Team {
//    var name = ""
//        private set
//    var dateOfEst = 0
//    var noOfTrophies = 0;
//
//    constructor(name : String , dateOfEst : Int , noOfTrophies : Int){
//        this.name = name
//        this.dateOfEst = dateOfEst
//        this.noOfTrophies = noOfTrophies
//    }
//
//    override fun toString(): String {
//        return """
//            name : ${this.name}
//            Date Of Establishment : ${this.dateOfEst}
//            No of Trophies : ${this.noOfTrophies}
//        """.trimIndent()
//    }
//}
//
//    val sum = add(2, 5)
//    print("Sum of 2 and 5 is $sum")
//fun add(a: Int , b : Int) : Int{
//    return a + b
//}

/*

//    for ((key , car) in mapOfCars)
//        println("this key $key is for car $car")
//
//    for (car in setOfCars)
//        println("the car name is $car")
//
//    for (i in 1..100 step 5)
//        println(i)
  val arrayOfCars = arrayOf("MccLaren", "BMW" , "Toyota" , "Mercedes")
    val listOfCars = mutableListOf("MccLaren", "BMW" , "Toyota" , "Mercedes")
    val setOfCars = mutableSetOf("MccLaren", "BMW" , "Toyota" , "Mercedes","MccLaren", "BMW" , "Toyota" , "Mercedes")

    val mapOfCars = mutableMapOf("M" to "MccLaren", "B" to "BMW" , 1 to "One" )
    val mapOfCars2 = mapOf("M" to "MccLaren", "B" to "BMW" , 1 to "One" )

    if("BMW" in listOfCars)
        println("Car does exist")

    listOfCars.add("Dodge")

    mapOfCars["Z"] = "new Element"

    println(arrayOfCars[1])
    println(mapOfCars[1])
    println(mapOfCars["M"])


    println(listOfCars)
    println(setOfCars)

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


