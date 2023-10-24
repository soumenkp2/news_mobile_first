package com.example.news_mobile_first.viewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.news_mobile_first.model_class.Article
import com.example.news_mobile_first.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    private val _pagingData = MutableLiveData<PagingData<Article>>()
    val pagingData: LiveData<PagingData<Article>> get() = _pagingData

    /*fetching news from repository class which can be loaded to UI*/
    fun fetchNews(category: String) {
        viewModelScope.launch {
            val pagingSource = repository.getNewsPagingSource(category)
            val pager = Pager(
                config = PagingConfig(pageSize = 20, enablePlaceholders = false),
                pagingSourceFactory = { pagingSource }
            )

            val pagingData = pager.flow.cachedIn(viewModelScope)
            pagingData.asLiveData().observeForever {
                _pagingData.postValue(it)
            }
        }
    }
}