package com.example.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.BookListItem

class BookListViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val ivItemBookCover: ImageView = view.findViewById(R.id.iv_item_book_cover_id)
    val tvItemBookName: TextView = view.findViewById(R.id.tv_item_book_name_id)
    val tvItemBookWriter: TextView = view.findViewById(R.id.tv_item_book_writer_id)

    fun bind(data: BookListItem){
        ivItemBookCover.setImageResource(R.drawable.book_img)
        tvItemBookName.text = data.bookName
        tvItemBookWriter.text = data.bookWriter
    }
}
