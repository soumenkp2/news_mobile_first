package com.example.news_mobile_first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile_first.custom_adapters.NewsPagingAdapter
import com.example.news_mobile_first.custom_adapters.categAdapter
import com.example.news_mobile_first.databinding.ActivityMainBinding
import com.example.news_mobile_first.viewModels.NewsViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var pagingAdapter: NewsPagingAdapter
    private var categList : MutableList<String> = mutableListOf()
    private lateinit var categAdapter: categAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        pagingAdapter = NewsPagingAdapter()

        //to assign data into pagingData which can be observed later to setup the pagingAdapter
        viewModel.fetchNews("health")

        setObservers()
        addDemoDataCategory()

        binding.catRv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        categAdapter = categAdapter(this@MainActivity,categList,viewModel)
        binding.catRv.adapter = categAdapter

    }

    fun setObservers() {
        viewModel.pagingData.observe(this, Observer {
            binding.newsRv.layoutManager = LinearLayoutManager(this)
            Log.d("datafetched-uicontroller",it.toString())
            pagingAdapter.submitData(lifecycle,it)
            binding.newsRv.adapter = pagingAdapter
            pagingAdapter.notifyDataSetChanged()
        })
    }

    fun addDemoDataCategory() {
        categList.add("health")
        categList.add("politics")
        categList.add("business")
        categList.add("science")
        categList.add("sports")
        categList.add("technology")
    }
}