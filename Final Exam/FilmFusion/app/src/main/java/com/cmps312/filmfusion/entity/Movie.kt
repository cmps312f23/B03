package com.cmps312.filmfusion.entity

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Movie(
    var title: String,
    var director: String,
    var poster: String,
    var releaseDate: String,
    var rating: Double,
    var genreId : Int,
    var id : Int= Random.nextInt(1000)
)
