package com.photo.mahsa.data

import com.photo.mahsa.network.LocalDataSource
import com.photo.mahsa.network.RemoteDataSource

interface Repository {

}


class RepositoryImp(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): Repository {

}