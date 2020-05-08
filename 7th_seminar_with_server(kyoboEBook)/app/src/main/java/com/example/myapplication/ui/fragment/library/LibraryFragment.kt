package com.example.myapplication


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.data.BookListItem
import com.example.myapplication.data.MainBookData

/**
 * A simple [Fragment] subclass.
 */
class LibraryFragment(context: Context) : Fragment() {
    lateinit var mCardAdapter : MainBookAdapter
    lateinit var mViewPager : ViewPager
    private lateinit var rvMainBookList: RecyclerView
    private lateinit var bookListAdapter: BookListAdapter
    var ctx = context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_library, container, false)
        mViewPager = view.findViewById(R.id.main_viewPager)
        rvMainBookList = view.findViewById(R.id.rvMainBookList)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        initBookList()
    }
    private fun init(){

        mCardAdapter = MainBookAdapter(8)
        mCardAdapter.addBookItem(MainBookData(img_book_resource = R.drawable.book_left_img,book_title_resource = R.string.book_title_2,book_writer_resource = R.string.book_writer_2))
        mCardAdapter.addBookItem(MainBookData(img_book_resource = R.drawable.book_main_img,book_title_resource = R.string.book_title_1,book_writer_resource = R.string.book_writer_1))
        mCardAdapter.addBookItem(MainBookData(img_book_resource = R.drawable.book_right_img,book_title_resource = R.string.book_title_3,book_writer_resource = R.string.book_writer_3))

        val mCardShadowTransformer =
            ShadowTransformer(
                mViewPager,
                mCardAdapter
            )

        mViewPager.adapter = mCardAdapter
        mViewPager.setPageTransformer(false,mCardShadowTransformer)
        mViewPager.offscreenPageLimit=3
    }
    private fun initBookList(){



        bookListAdapter = BookListAdapter(ctx)

        rvMainBookList.adapter = bookListAdapter

        rvMainBookList.layoutManager = GridLayoutManager(ctx, 3)

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
