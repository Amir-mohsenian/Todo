package com.photo.mahsa.network

import com.photo.mahsa.model.Photo
import com.photo.mahsa.network.model.PhotoNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface Service {
    @GET("photos")
    suspend fun loadPhotosByPage(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("order_by") orderBy: String = NETWORK_LATEST_ORDER
    ): Response<List<PhotoNetwork>?>
}