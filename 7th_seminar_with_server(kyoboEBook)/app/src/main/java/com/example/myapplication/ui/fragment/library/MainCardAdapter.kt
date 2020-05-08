package com.example.myapplication

import androidx.cardview.widget.CardView

interface MainCardAdapter {
    val MAX_ELEVATION_FACTOR : Int
    fun getBaseElevation() : Float
    fun getCardViewAt(position : Int) : CardView
    fun getCount() : Int
}