package com.example.kyoboebook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyFragmentStatePagerAdapter (fm:FragmentManager, val fragmentCount: Int): FragmentStatePagerAdapter(fm){
    override fun getCount(): Int = fragmentCount

    override fun getItem(position: Int): Fragment? {
        when(position){
            0->return Main2Fragment()
            else -> return null
        }
    }
}