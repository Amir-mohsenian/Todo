package com.photo.mahsa.db

import com.photo.mahsa.db.model.PhotoEntity
import com.photo.mahsa.model.Photo

fun PhotoEntity.toPhoto() = Photo(
    id = this.unsplashId,
    url = this.url,
    favorite = this.isFav
)