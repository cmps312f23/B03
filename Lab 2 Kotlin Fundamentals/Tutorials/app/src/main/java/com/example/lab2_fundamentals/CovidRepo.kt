package com.example.lab2_fundamentals

import kotlinx.serialization.json.Json
import java.io.File

object CovidStatRepository {
    var covidStats = listOf<CovidStats>()

    init {
        //step 1 read from the file
        var data = File("data/covid-data.json").readText()

        //step is convert the text into object
        //ignoreUnknownKeys - allows us to ignore some of the fields
        covidStats = Json { ignoreUnknownKeys = true }.decodeFromString(data)
    }

    fun totalCovidDeath() = covidStats.sumOf { it?.totalDeaths ?: 0 }

}

fun main(args: Array<String>) {
    println(CovidStatRepository.covidStats)
}