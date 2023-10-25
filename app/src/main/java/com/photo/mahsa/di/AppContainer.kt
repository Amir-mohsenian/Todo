package com.photo.mahsa.di

import android.content.Context
import androidx.room.Room
import com.photo.mahsa.data.RepositoryImp
import com.photo.mahsa.data.LocalDataSourceImp
import com.photo.mahsa.db.AppDatabase
import com.photo.mahsa.network.RemoteDataSourceImp
import com.photo.mahsa.network.Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {

    private val roomDb = Room.databaseBuilder(context, AppDatabase::class.java, "mahsa-db")
 //   private val localDataSource = LocalDataSourceImp(roomDb.build().photoDao())

    val repository = RepositoryImp()
}
