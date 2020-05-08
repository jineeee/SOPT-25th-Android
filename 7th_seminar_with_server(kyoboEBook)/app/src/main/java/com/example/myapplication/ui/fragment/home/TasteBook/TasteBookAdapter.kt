package com.example.myapplication.ui.fragment.home.TasteBook

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.BookTasteItem


class TasteBookAdapter (private val context: Context): RecyclerView.Adapter<HomeTasteViewHolder>(){

    var data = listOf<BookTasteItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTasteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_taste_rv_item,parent,false)

        return HomeTasteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeTasteViewHolder, position: Int) {
        holder.bind(data[position])
    }
}