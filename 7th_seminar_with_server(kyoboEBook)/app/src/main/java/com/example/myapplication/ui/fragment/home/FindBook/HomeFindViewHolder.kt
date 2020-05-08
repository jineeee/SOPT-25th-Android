package com.example.myapplication.ui.fragment.home.FindBook
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.BookItem

class HomeFindViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        //val rv_homeFind_item: View = view.findViewById(R.id.rv_homeFind)
        val homeFind_img_book: ImageView = view.findViewById(R.id.homeFind_img_book)
        val homeFind_txt_book: TextView = view.findViewById(R.id.homeFind_txt_book)
        val homeFind_txt_author: TextView = view.findViewById(R.id.homeFind_txt_author)
        val homeFind_ratingbar : RatingBar = view.findViewById(R.id.homeFind_ratingbar)
        val homeFind_txt_rating: TextView = view.findViewById(R.id.homeFind_txt_rating)
        val homeFind_checkbox: CheckBox = view.findViewById(R.id.homeFind_checkbox)

        fun bind(data: BookItem) {
            Glide.with(itemView).load(data.bookCover).into(homeFind_img_book)
            homeFind_txt_book.text = data.bookName
            homeFind_txt_author.text = data.author
            homeFind_ratingbar.rating = data.star
            homeFind_txt_rating.text = data.star.toString()
            //homeFind_txt_rating.text = data.rating.toString()+" ("+data.num+")"
        }

}