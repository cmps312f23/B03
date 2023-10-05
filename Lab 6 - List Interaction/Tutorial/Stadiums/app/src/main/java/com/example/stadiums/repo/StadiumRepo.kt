package com.example.stadiums.repo

import android.content.Context
import com.example.stadiums.model.Stadium
import kotlinx.serialization.json.Json

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

}