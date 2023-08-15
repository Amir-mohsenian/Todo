package com.photo.mahsa.network.model

import com.google.gson.annotations.SerializedName

data class PhotoNetwork(
   val id: String,
    @SerializedName("created_at")
    val createdAt: String,
    val width: String,
    val height: String,
    val color: String,
    @SerializedName("blur_hash")
    val blurHash: String,
    val downloads: Int,
    val likes: Int,
    val description: String,
    @SerializedName("location")
    val location: Location?,
    val tags: List<Tag>,
    val urls: PhotoUrls,
)