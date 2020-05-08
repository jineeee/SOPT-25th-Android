package com.example.week2_homework_final

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week2_homework_final.data.GetFollowerData

class ProfileAdapter(private var context: Context) : RecyclerView.Adapter<ProfileViewHolder>(){

    var data = listOf<GetFollowerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(data[position])
    }

}