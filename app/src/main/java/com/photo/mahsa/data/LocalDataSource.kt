package com.photo.mahsa.data

import com.photo.mahsa.db.TaskDao

interface LocalDataSource {
}

class LocalDataSourceImp(
    private val taskDao: TaskDao
) : LocalDataSource {

}

