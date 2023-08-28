package com.photo.mahsa.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.photo.mahsa.network.model.PhotoNetwork
import retrofit2.HttpException

class PhotosPagingSource(
    private val service: Service
) : PagingSource<Int, PhotoNetwork>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoNetwork> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = service.loadPhotosByPage(
                page = nextPageNumber,
                clientId = "ofL_RZuAUkhc6fRkUM4I63owhLO7l5ZFkHcn5M2yXmc"
            )

            return LoadResult.Page(
                data = response.body() ?: emptyList(),
                prevKey = null,
                nextKey = nextPageNumber + 1
            )

        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PhotoNetwork>): Int? {
        return null
    }
}