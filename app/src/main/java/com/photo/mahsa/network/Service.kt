package com.photo.mahsa.network

import com.photo.mahsa.model.Photo
import com.photo.mahsa.network.model.PhotoNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface Service {
    @GET("?client_id=ofL_RZuAUkhc6fRkUM4I63owhLO7l5ZFkHcn5M2yXmc")
    suspend fun loadPhotosByPage(
    ): Response<List<PhotoNetwork>?>
}