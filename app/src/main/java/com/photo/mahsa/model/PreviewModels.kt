package com.photo.mahsa.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState


val photoSuccessListPreview = listOf<Photo>(
    Photo(
    "322", "url", false
)
)
object PreviewPaging: PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
       return LoadResult.Page(photoSuccessListPreview, 1, 3)
    }
}

val PreviewPagingDataFlow = Pager(
    config = PagingConfig(pageSize = 20),
    initialKey = null
) { PreviewPaging }.flow