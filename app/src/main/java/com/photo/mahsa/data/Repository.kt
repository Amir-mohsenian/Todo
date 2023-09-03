package com.photo.mahsa.data

import androidx.paging.PagingData
import androidx.paging.map
import com.photo.mahsa.model.Photo
import com.photo.mahsa.network.RemoteDataSource
import com.photo.mahsa.network.model.PhotoNetwork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface Repository {
    fun loadPhotos(pageSize: Int): Flow<PagingData<Photo>>
}


class RepositoryImp(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun loadPhotos(pageSize: Int): Flow<PagingData<Photo>> {
        return remoteDataSource.loadPhotos(pageSize)
            .map {
                it.map { photoNetwork: PhotoNetwork ->
                    Photo(
                        photoNetwork.id,
                        photoNetwork.urls.regular,
                        false
                    )
                }
            }
    }
}