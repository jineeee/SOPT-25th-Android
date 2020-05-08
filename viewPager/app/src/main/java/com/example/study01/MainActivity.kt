package com.example.study01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainFragment: MainFragment
    private lateinit var mapFragment: MapFragment
    private lateinit var myPageFragment: MyPageFragment
    private lateinit var pager :ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = MyFragmentStatePagerAdapter(supportFragmentManager, 3)
        pager = findViewById<ViewPager>(R.id.container)
        pager.adapter = pagerAdapter
        pager.setCurrentItem(1)

        bottomNaviBar.menu.getItem(1).setChecked(true)
        bottomNavi() //아이템을 클릭하면 프래그먼트가 바뀌도록 해준다
        changeItem() //뷰페이저로 프래그먼트를 넘기면 선택된 아이템이 바뀌게 해준다

//        mainFragment = MainFragment()
//        mapFragment = MapFragment()
//        myPageFragment = MyPageFragment()
//        setFrag(1)
    }

//    private fun setFrag(n: Int){
//        val fm: FragmentManager = supportFragmentManager
//        val ft = fm.beginTransaction()
//        when(n) {
//            0 -> {
//                ft.replace(R.id.container, mainFragment)
//                ft.commit()
//            }
//            1 -> {
//                ft.replace(R.id.container, mapFragment)
//                ft.commit()
//            }
//            2 -> {
//                ft.replace(R.id.container, myPageFragment)
//                ft.commit()
//            }
//        }
//    }
//
    private fun bottomNavi(){
        bottomNaviBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.action_one -> {
                    pager.setCurrentItem(0)
                }
                R.id.action_two -> {
                    pager.setCurrentItem(1)
                }
                R.id.action_three -> {
                    pager.setCurrentItem(2)
                }
            }
            true
        }
    }

    private fun changeItem(){
        var prevMenuItem:MenuItem? = null

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null)
                    prevMenuItem?.setChecked(false);
                else
                    bottomNaviBar.getMenu().getItem(0).setChecked(false);

                bottomNaviBar.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNaviBar.getMenu().getItem(position);
            }
        })
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val actionBar = supportActionBar
//        actionBar?.setDisplayShowTitleEnabled(false)
//        return true
//    }
}
