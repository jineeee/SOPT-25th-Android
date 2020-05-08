package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdRvAdapter(val context: Context, val mainadList: ArrayList<Main_ad>):
RecyclerView.Adapter<MainAdRvAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_ad_rv_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mainadList[position], context)
    }

    override fun getItemCount(): Int {
        return mainadList.size
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val adPhoto = itemView?.findViewById<ImageView>(R.id.img_main_ad)
        val adTitle = itemView?.findViewById<TextView>(R.id.txt_title)
        val adSub = itemView?.findViewById<TextView>(R.id.txt_sub)

        fun bind (mainad: Main_ad, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (mainad.photo != "") {
                val resourceId = context.resources.getIdentifier(mainad.photo, "drawable", context.packageName)
                adPhoto?.setImageResource(resourceId)
            } else {
                adPhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            adTitle?.text = mainad.title
            adSub?.text = mainad.sub
        }
    }
}