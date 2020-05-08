package com.example.week2_homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant

class ProfileActivity : AppCompatActivity() {

    private lateinit var rvMainProfile: RecyclerView
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initProfileList()
    }

    private fun initProfileList(){

        rvMainProfile = findViewById(R.id.rvMainProfile)
        profileAdapter = ProfileAdapter(this)
        rvMainProfile.adapter = profileAdapter
        rvMainProfile.layoutManager = LinearLayoutManager(this)
        profileAdapter.data = listOf(
            ProfileItem(
                id = "jinee0717",
                name = "Kim Ye Jin"
            ),ProfileItem(
                id = "myteacher",
                name = "Kim Chan Young"
            ),ProfileItem(
                id = "yamyam123",
                name = "Ha Ri Bo"
            )
        )
        profileAdapter.notifyDataSetChanged()
    }
}