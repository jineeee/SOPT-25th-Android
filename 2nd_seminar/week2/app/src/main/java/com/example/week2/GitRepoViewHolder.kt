package com.example.week2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val txtRvTitle:TextView = view.findViewById(R.id.txt_title)
    val txtRvDesc:TextView = view.findViewById(R.id.txt_desc)
    val txtRvLang:TextView = view.findViewById(R.id.txt_lang)

    fun bind(data: GitRepoItem) {
        txtRvTitle.text = data.title
        txtRvDesc.text = data.desc
        txtRvLang.text = data.lang
    }
}