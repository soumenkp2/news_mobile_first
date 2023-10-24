package com.example.news_mobile_first.model_class

data class NewsList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)