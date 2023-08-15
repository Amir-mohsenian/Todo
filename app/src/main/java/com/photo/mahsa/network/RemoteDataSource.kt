package com.photo.mahsa.network

interface RemoteDataSource {

}

class RemoteDataSourceImp(
    private val service: Service
): RemoteDataSource {

}