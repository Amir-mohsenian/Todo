package com.photo.mahsa.network.model

data class Location(
    val city: String,
    val country: String,
    val position: Position?

)

data class Position(
    val latitude: String,
    val longitude: String
)
