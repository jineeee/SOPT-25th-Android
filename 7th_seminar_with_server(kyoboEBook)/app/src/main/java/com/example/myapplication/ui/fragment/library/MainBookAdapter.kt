package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.data.MainBookData


class MainBookAdapter (override val MAX_ELEVATION_FACTOR: Int) : MainCardAdapter,PagerAdapter(){
    var mViews = mutableListOf<CardView?>()
    var mData = mutableListOf<MainBookData>()
    var mBaseElevation: Float = 0.0f
    override fun getBaseElevation(): Float {
        return mBaseElevation
    }
    fun addBookItem(item : MainBookData){
        mViews.add(null)
        mData.add(item)
    }
    override fun getCardViewAt(position: Int): CardView {
        return mViews.get(position)!!
    }


    override fun getCount(): Int {
        return mData.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = LayoutInflater.from(container.context)
            .inflate(R.layout.item_book_top,container,false)
        view.setBackgroundColor(Color.TRANSPARENT)
        container.addView(view)
        bind(mData.get(position),view)
        val cardView : CardView = view.findViewById(R.id.cardView)

        if(mBaseElevation == 0f){
            mBaseElevation = cardView.cardElevation
        }
        cardView.maxCardElevation=mBaseElevation*MAX_ELEVATION_FACTOR
        mViews.set(position,cardView)

        return view
    }
    private fun bind(item:MainBookData , view : View){
        val book_imgView : ImageView = view.findViewById(R.id.img_book)
        val book_title_TextView : TextView = view.findViewById(R.id.book_title)
        val book_writer_TextView  : TextView = view.findViewById(R.id.book_writer)
        book_imgView.setImageResource(item.img_book_resource)
        book_title_TextView.setText(item.book_title_resource)
        book_writer_TextView.setText(item.book_writer_resource)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
        mViews.set(position,null)
    }
}