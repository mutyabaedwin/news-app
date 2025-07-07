package com.emutyaba.mynews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NewsAdapter(private val newsList: List<NewsItem>) :
        RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

        inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.newsImage)
            val titleView: TextView = itemView.findViewById(R.id.newsTitle)
            val descView: TextView = itemView.findViewById(R.id.newsDescription)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
            return NewsViewHolder(view)
        }

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            val news = newsList[position]
            holder.imageView.setImageResource(news.imageResId)
            holder.titleView.text = news.title
            holder.descView.text = news.description
        }

        override fun getItemCount() = newsList.size
    }

