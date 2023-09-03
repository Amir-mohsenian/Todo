package com.photo.mahsa.data

import com.photo.mahsa.db.model.PhotoEntity
import com.photo.mahsa.model.Photo

fun Photo.toPhotoEntity() = PhotoEntity(
    unsplashId = this.id,
    url = this.url,
    isFav = this.favorite
)