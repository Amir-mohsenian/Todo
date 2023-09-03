package com.photo.mahsa.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.photo.mahsa.db.model.PhotoEntity

@Dao
interface PhotoDao {
   @Insert
   suspend fun insertPhoto(photo: PhotoEntity): Long

   @Query("SELECT * FROM photo WHERE unsplash_id = :unsplashId")
   suspend fun loadPhoto(unsplashId: String): PhotoEntity?
}