package com.example.myapplication


import HomeFragment
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.ColorDrawable
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.rv_main_ad
import java.nio.file.Files.find


class MainActivity : AppCompatActivity() {
    private lateinit var libraryFragment: LibraryFragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var accountFragment: AccountFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationBar.menu.getItem(1).setChecked(true)
        libraryFragment = LibraryFragment(this)
        homeFragment = HomeFragment()
        accountFragment = AccountFragment()
        setFrag(1)
        bottomNavi()

    }


    private fun setFrag(n: Int) {
        val fm: FragmentManager = supportFragmentManager
        val ft = fm.beginTransaction()
        when (n) {
            0 -> { // 서재
                ft.replace(R.id.container, libraryFragment)
                ft.commit()
            }
            1 -> { // 홈
                ft.replace(R.id.container, homeFragment)
                ft.commit()
            }
            2 -> { // 내 계정
                ft.replace(R.id.container, accountFragment)
                ft.commit()
            }
        }
    }


    private fun bottomNavi() {
        bottomNavigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_myLibrary -> {
                    setFrag(0)
                }
                R.id.menu_home -> {
                    setFrag(1)
                }
                R.id.menu_myAccount -> {
                    setFrag(2)
                }
            }
            true
        }
    }

    //액션바
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val actionBar = supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false)


        // val menuInflater = menuInflater
        // menuInflater.inflate(R.layout.menu_top, menu)
        return true
        //supportActionBar!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        //supportActionBar!!.setCustomView(R.layout.top_menu)     //layout폴더 menu가 상단바 구성
        //supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#255ad2")))
    }

}
