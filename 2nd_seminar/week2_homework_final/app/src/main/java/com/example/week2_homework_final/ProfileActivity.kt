package com.example.week2_homework_final

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week2_homework_final.api.GithubServiceImpl
import com.example.week2_homework_final.data.GetFollowerData
import com.example.week2_homework_final.data.GetUserData
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val followerCall: Call<List<GetFollowerData>> = GithubServiceImpl.service.getFollowers("ghkdua1829")
        val userCall: Call<GetUserData> = GithubServiceImpl.service.getUser("jineeee")

        followerCall.enqueue(
            object : Callback<List<GetFollowerData>> {
                override fun onFailure(call: Call<List<GetFollowerData>>, t: Throwable) {
                    Log.e("sopt_git_follower", "error: $t")
                }

                override fun onResponse(
                    call: Call<List<GetFollowerData>>,
                    response: Response<List<GetFollowerData>>
                ) {
                    if(response.isSuccessful){
                        val gitFollowers = response.body()!!
                        profileAdapter.data = gitFollowers
                        profileAdapter.notifyDataSetChanged()
                    }
                }
            }
        )

        userCall.enqueue(
            object : Callback<GetUserData> {
                override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                    Log.e("sopt_user", "error: $t")
                }

                override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                    Log.e("sds","Aaa"+response.body()!!)
                    if(response.isSuccessful){
                        Glide.with(this@ProfileActivity)
                            .load(response.body()!!.avatarUrl)
                            .into(iv_myProfile_img)
                        tv_myProfile_id.setText(response.body()!!.id)
                        tv_myProfile_name.setText(response.body()!!.name)
                        tv_myProfile_desc.setText(response.body()!!.bio)
                    }
                }
            }
        )

//        profileAdapter.data = listOf(
//            ProfileItem(
//                id = "jinee0717",
//                name = "Kim Ye Jin"
//            ),ProfileItem(
//                id = "myteacher",
//                name = "Kim Chan Young"
//            ),ProfileItem(
//                id = "yamyam123",
//                name = "Ha Ri Bo"
//            )
//        )
//        profileAdapter.notifyDataSetChanged()
    }
}