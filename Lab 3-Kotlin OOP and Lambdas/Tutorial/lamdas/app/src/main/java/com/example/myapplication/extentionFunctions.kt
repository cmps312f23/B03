package com.example.myapplication

fun main() {
    val name : String = "Mohamed"

//    println(countVowels(name))
    println(name.length)

    println(name.countVowels())
    println(6.isEven())

    for (i in 1 .. 100)
        if(i.isEven()) println(i)

    val a = A()
    val b = A()
    val c = A()

    a.foo()
    b.foo()
    b.isAnotherFoo()
}

class A {
    fun foo() {

    }

}

fun A.isAnotherFoo() = true


fun Int.isEven() = this % 2 ==0

fun String.countVowels(): Int {
    var count = 0
    var vowels = "aeiou"
    for (i in this) {
        if(i in vowels) count++
    }
    return count
}


