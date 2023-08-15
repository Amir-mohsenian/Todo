package com.photo.mahsa.di

import com.photo.mahsa.data.RepositoryImp
import com.photo.mahsa.network.LocalDataSourceImp
import com.photo.mahsa.network.RemoteDataSourceImp
import com.photo.mahsa.network.Service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = ""
class AppContainer {

    private val networkService = provideNetworkService()
    private val localDataSource = LocalDataSourceImp()
    private val remoteDataSource = RemoteDataSourceImp(networkService)

    val repository = RepositoryImp(localDataSource, remoteDataSource)
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}
private fun provideRetrofit() =
    Retrofit.
    Builder().
    baseUrl(BASE_URL).
    addConverterFactory(GsonConverterFactory.create()).
    client(provideOkHttpClient()).build()

private fun provideNetworkService(): Service {
    val retrofit = provideRetrofit()
    return retrofit.create(Service::class.java)
}