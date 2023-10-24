package com.example.news_mobile_first.repository

import androidx.paging.PagingSource
import com.example.news_mobile_first.RetrofitClient
import com.example.news_mobile_first.model_class.Article
import com.example.news_mobile_first.model_class.NewsList
import com.example.news_mobile_first.paging.NewsPagingSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    interface NewsRepositoryCallback<T> {
        fun onSuccessfullyDataFetched(data: T)
        fun onErrorNewsData(errorMessage: String)
    }


    private val apiService = RetrofitClient.apiService

    fun getNewsPagingSource(category: String): PagingSource<Int, Article> {
        return NewsPagingSource(apiService, category)
    }

//    fun getTopHeadlines(callback: NewsRepositoryCallback<List<Article>>, category:String) {
//        apiService.getTopHeadlines(category,1).enqueue(object : Callback<NewsList> {
//            override fun onResponse(call: Call<NewsList>, response: Response<NewsList>) {
//                if (response.isSuccessful) {
//                    val articles: List<Article>? = response.body()?.articles
//                    if (articles != null) {
//                        callback.onSuccessfullyDataFetched(articles)
//                    } else {
//                        callback.onErrorNewsData("No articles found")
//                    }
//                } else {
//                    callback.onErrorNewsData("Error occurred")
//                }
//            }
//
//            override fun onFailure(call: Call<NewsList>, t: Throwable) {
//                callback.onErrorNewsData("Network error: ${t.message}")
//            }
//        })
//    }



}