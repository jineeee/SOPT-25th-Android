package com.example.study01

import android.app.PendingIntent.getActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyFragmentStatePagerAdapter (fm : FragmentManager, val fragmentCount : Int): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return MainFragment().newInstance()
            1 -> return MapFragment().newInstance()
            2 -> return MyPageFragment().newInstance()
            else -> null!!
        }
    }


    override fun getCount(): Int = fragmentCount

}