package com.photo.mahsa.data

import com.photo.mahsa.db.PhotoDao
import com.photo.mahsa.model.Photo

interface LocalDataSource {
    suspend fun insertPhoto(photo: Photo): Boolean
}

class LocalDataSourceImp(
    private val photoDao: PhotoDao
) : LocalDataSource {
    override suspend fun insertPhoto(photo: Photo): Boolean =
        photoDao.insertPhoto(photo.toPhotoEntity()) == 0L

}

