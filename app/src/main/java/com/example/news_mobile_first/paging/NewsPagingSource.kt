package com.example.news_mobile_first.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.news_mobile_first.interfaces.NewsApiService
import com.example.news_mobile_first.model_class.Article

class NewsPagingSource(
    private val apiService: NewsApiService,
    private val category: String
) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        Log.d("datafetched-loadfunction","$page")
        return try {
            val response = apiService.getTopHeadlines(category)
            val articles = response.articles
            Log.d("datafetched-pagingsource",articles.toString())
            LoadResult.Page(
                data = articles,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (articles?.isEmpty() == true) null else page + 1
            )
        } catch (e: Exception) {
            Log.d("datafetched-error",e.toString())
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        Log.d("datafetched-refresh","yess")
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}