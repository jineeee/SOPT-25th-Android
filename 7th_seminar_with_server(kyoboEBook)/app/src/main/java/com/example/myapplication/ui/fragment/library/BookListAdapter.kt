package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.BookListItem

class BookListAdapter(private val context: Context) : RecyclerView.Adapter<BookListViewHolder>(){

    var data = listOf<BookListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return BookListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(data[position])
    }

}