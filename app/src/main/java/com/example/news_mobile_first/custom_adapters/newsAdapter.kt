package com.example.news_mobile_first.custom_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile_first.R
import com.example.news_mobile_first.model_class.Article

class newsAdapter(private val articleList : List<Article>) : RecyclerView.Adapter<newsAdapter.NewsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articleItem = articleList[position]

        // sets the image to the imageview from our itemHolder class
        //holder.newsImage.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.newsHeadline.text = articleItem.title.toString()
    }

    class NewsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        val newsHeadline: TextView = itemView.findViewById(R.id.newsHeadline)
        val newsTime: TextView = itemView.findViewById(R.id.newsTime)
        val newsVews: TextView = itemView.findViewById(R.id.newsView)
    }
}