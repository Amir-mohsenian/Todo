package com.photo.mahsa.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.photo.mahsa.network.model.PhotoNetwork
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun loadPhotos(pageSize: Int): Flow<PagingData<PhotoNetwork>>
}

class RemoteDataSourceImp(
    private val service: Service
): RemoteDataSource {
    override fun loadPhotos(pageSize: Int): Flow<PagingData<PhotoNetwork>> {
        return Pager(
            config = PagingConfig(pageSize = pageSize)
        ) {
            PhotosPagingSource(service)
        }.flow
    }
}