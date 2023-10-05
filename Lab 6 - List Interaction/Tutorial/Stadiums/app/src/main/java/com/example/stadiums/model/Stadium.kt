package com.example.stadiums.model

import kotlinx.serialization.Serializable

@Serializable
data class Stadium(
    val name : String ,
    val city : String,
    val status : String,
    val imageName : String,
    val seatingCapacity : Int
)

/*

  {
    "name": "Al-Gharafa Stadium",
    "city": "Al-Rayyan",
    "status": "Major renovation",
    "imageName": "al_gharafa",
    "seatingCapacity": 2412
  },
 */