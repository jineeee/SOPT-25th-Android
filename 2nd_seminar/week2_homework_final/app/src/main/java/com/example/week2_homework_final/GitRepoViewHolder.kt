package com.example.week2_homework_final

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week2_homework_final.R
import com.example.week2_homework_final.data.GetGitRepoData

class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val txtRvTitle:TextView = view.findViewById(R.id.txt_title)
    val txtRvDesc:TextView = view.findViewById(R.id.txt_desc)
    val txtRvLang:TextView = view.findViewById(R.id.txt_lang)

    fun bind(data: GetGitRepoData) {
        txtRvTitle.text = data.name
        txtRvDesc.text = data.description
        txtRvLang.text = data.language
    }
}