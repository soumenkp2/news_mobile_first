package com.example.news_mobile_first.custom_adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile_first.R
import com.example.news_mobile_first.viewModels.NewsViewModel

class categAdapter(private var context: Context, private var categList : List<String>, private var viewModel:NewsViewModel) : RecyclerView.Adapter<categAdapter.CategViewHolder>(){

    //to track the current selected item to highlight it with black text color
    private var selectedItemPosition = 0

    class CategViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val underline: View = itemView.findViewById(R.id.underline)
        val categ: TextView = itemView.findViewById(R.id.categtext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categAdapter.CategViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_category, parent, false)

        return categAdapter.CategViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categList.size
    }

    override fun onBindViewHolder(holder: categAdapter.CategViewHolder, position: Int) {
        val item = categList[position]
        // sets the text to the textview from our itemHolder class
        holder.categ.text = item.toString()
        holder.categ.setOnClickListener {
            selectedItemPosition = holder.absoluteAdapterPosition
            Log.d("clickedcateg",it.toString())
            viewModel.fetchNews(item.toString())
            holder.categ.setTextColor(ContextCompat.getColor(context, R.color.black))
            notifyDataSetChanged()
        }

        if(position == selectedItemPosition) {
            holder.categ.setTextColor(ContextCompat.getColor(context, R.color.black))
            holder.underline.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
        } else {
            holder.categ.setTextColor(ContextCompat.getColor(context, R.color.grey))
            holder.underline.setBackgroundColor(ContextCompat.getColor(context, R.color.grey))
        }
    }
}