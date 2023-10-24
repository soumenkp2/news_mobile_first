package com.example.news_mobile_first.interfaces

import com.example.news_mobile_first.model_class.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines?country=us&apiKey=f172673e56314af0a5adf071e07666a9")
    suspend fun getTopHeadlines(@Query("category") category: String): NewsList

}