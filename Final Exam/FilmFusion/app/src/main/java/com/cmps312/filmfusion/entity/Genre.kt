package com.cmps312.filmfusion.entity

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    var name: String = "",
    var image: String = "",
    var id: Int = 0
)