package com.example.week2_homework

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val txtRvId: TextView = view.findViewById(R.id.txt_id)
    val txtRvName: TextView = view.findViewById(R.id.txt_name)

    fun bind(data: ProfileItem) {
        txtRvId.text = data.id
        txtRvName.text = data.name
    }
}