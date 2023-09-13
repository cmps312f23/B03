package com.example.lab2_fundamentals

import kotlinx.serialization.Serializable


@Serializable
data class CovidStats(
    var id: Int,
    var country: String,
    var continent: String,
    var region: String,
    var totalCases: Int?,
    var totalDeaths: Int?,
    var newDeaths: Int?,
    var totalRecovered: Int?,
    var newRecovered: Int?,
    var activeCases: Int?,
    var population: Int?
)