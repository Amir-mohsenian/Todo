package com.photo.mahsa.di

import com.photo.mahsa.data.RepositoryImp
import com.photo.mahsa.data.LocalDataSourceImp
import com.photo.mahsa.network.RemoteDataSourceImp
import com.photo.mahsa.network.Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.unsplash.com/"
class AppContainer {

    private val networkService = provideNetworkService()
    private val localDataSource = LocalDataSourceImp()
    private val remoteDataSource = RemoteDataSourceImp(networkService)

    val repository = RepositoryImp(localDataSource, remoteDataSource)
}

private fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
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