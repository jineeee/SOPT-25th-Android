package com.example.kyoboebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kyoboebook.data.BookListItem
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvMainBookList: RecyclerView
    private lateinit var bookListAdapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBookList()
    }


    private fun initBookList(){

        rvMainBookList = findViewById(R.id.rvMainBookList)

        bookListAdapter = BookListAdapter(this)

        rvMainBookList.adapter = bookListAdapter

        rvMainBookList.layoutManager = GridLayoutManager(this, 3)

        bookListAdapter.data = listOf(
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            ),
            BookListItem(
                bookName = "생각을 선물하는 남자",
                bookWriter = "유형일"
            )
        )
        bookListAdapter.notifyDataSetChanged()
    }
}
