package com.example.stadiums.repo

import android.content.Context
import com.example.stadiums.model.Stadium
import kotlinx.serialization.json.Json

object SortOptions {
    const val NAME = "NAME"
    const val CITY = "CITY"
    const val SEATING_CAPACITY = "SEATING_CAPACITY"
    const val DEFAULT = "DEFAULT"
}
object StadiumRepo {
    var stadiums = listOf<Stadium>()

    fun getStadiums(context: Context): List<Stadium> {
        if (stadiums.isEmpty()) {
            //read from the file assets folder
            val stadiumJsonText = context
                .assets
                .open("stadiums.json")
                .bufferedReader().use { it.readText() }

            //parse the content
            stadiums = Json { ignoreUnknownKeys = true }
                .decodeFromString(stadiumJsonText)
        }
        return stadiums
    }

    //    filter the stadium by name and city
    fun filterStadium(query: String) = stadiums.filter {
        it.name.contains(query, ignoreCase = true) or it.city.contains(query, ignoreCase = true)
    }

    fun sortStadiums(sortOption : String) = when(sortOption) {
        SortOptions.NAME -> stadiums.sortedBy { it.name }
        SortOptions.CITY -> stadiums.sortedBy { it.city }
        SortOptions.SEATING_CAPACITY -> stadiums.sortedBy { it.seatingCapacity }
        else -> stadiums
    }
}
