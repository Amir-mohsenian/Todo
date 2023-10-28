package com.photo.mahsa.di

import android.content.Context
import androidx.room.Room
import com.photo.mahsa.data.RepositoryImp
import com.photo.mahsa.db.AppDatabase

class AppContainer(context: Context) {

    private val roomDb = Room.databaseBuilder(context, AppDatabase::class.java, "mahsa-db").build()
    private val taskDao = roomDb.taskDao()

    val repository = RepositoryImp(taskDao)
}
