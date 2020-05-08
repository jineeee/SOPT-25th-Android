package com.example.study01

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import java.util.jar.Attributes

class MyFragmentStatePager(ctx: Context, attr: AttributeSet) : ViewPager(ctx, attr){

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}