package com.photo.mahsa.network

import com.photo.mahsa.network.model.PhotoNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Service {
    @GET("photos/")
    suspend fun loadPhotosByPage(
        @Query("page") page: Int,
        @Query("client_id") clientId: String
    ): Response<List<PhotoNetwork>?>
}