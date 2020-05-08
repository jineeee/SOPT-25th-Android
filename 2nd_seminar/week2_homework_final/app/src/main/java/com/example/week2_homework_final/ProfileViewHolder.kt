package com.example.week2_homework_final

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week2_homework_final.data.GetFollowerData

class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val contRvLayout: ConstraintLayout = view.findViewById(R.id.cl_item_profile_container)
    val txtRvId: TextView = view.findViewById(R.id.tv_item_profile_id)
    val txtRvName: TextView = view.findViewById(R.id.tv_item_profile_name)

    fun bind(data: GetFollowerData) {
        txtRvId.text = data.id
        txtRvName.text = data.login

        contRvLayout.setOnClickListener{
            val intent = Intent(itemView.context, GitRepoActivity::class.java)
            startActivity(itemView.context, intent,null)
        }
    }
}