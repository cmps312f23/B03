package com.example.myapplication

import kotlinx.serialization.json.Json
import java.io.File

object CovidStatRepo {
    var covidStats = listOf<CovidStat>()

    init {
//        read the text from the file using java file system
        val contentOfTheFile = File("data/covid-data.json").readText()
        covidStats = Json { ignoreUnknownKeys = true }
            .decodeFromString(contentOfTheFile)
    }

    fun findCountry(country: String) = covidStats.find { it.country == country }
    fun totalDeath() =
        covidStats.fold(0) { acc: Int, b: CovidStat -> (acc + (b.totalDeaths ?: 0)) } }

}

fun main(args: Array<String>) {
//    println(CovidStatRepo.covidStats)
    println(CovidStatRepo.finCountry("India"))

//    [1,2,3,4,5].filter().reduce()
}