package com.example.news_mobile_first.custom_adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile_first.DetailScreen
import com.example.news_mobile_first.databinding.ItemNewsBinding
import com.example.news_mobile_first.model_class.Article
import com.squareup.picasso.Picasso

class NewsPagingAdapter : PagingDataAdapter<Article, NewsPagingAdapter.NewsViewHolder>(ArticleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = getItem(position)
        article?.let {
            holder.bind(it)
        }
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            Log.d("datafetched-viewholderitem",article.title.toString())
            binding.newsHeadline.text = article.title.toString()
            if(article.urlToImage!=null){
                Picasso.get().load(article.urlToImage.toString()).into(binding.newsImage)
            }
            binding.newsTime.text = article.publishedAt.toString()
            binding.executePendingBindings()

            //On click of any item which redirects to DetailScreenActivity
            binding.newsitem.setOnClickListener {
                val intent = Intent(binding.root.context, DetailScreen::class.java)
                intent.putExtra("imageurl",article.urlToImage)
                intent.putExtra("title",article.title)
                intent.putExtra("description",article.description)
                intent.putExtra("content",article.content)
                intent.putExtra("author",article.author)
                intent.putExtra("time",article.publishedAt)
                intent.putExtra("url",article.url)
                binding.root.context.startActivity(intent)
            }
        }
    }

    // DiffCallback to efficiently update items in the RecyclerView
    private class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url // Use a unique identifier for items
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem // Check if the items have the same content
        }
    }
}
