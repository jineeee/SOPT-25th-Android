package com.example.week2_homework_final

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week2_homework_final.api.GithubServiceImpl
import com.example.week2_homework_final.data.GetGitRepoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoActivity : AppCompatActivity() {

    private lateinit var rvMainGitRepo: RecyclerView
    private lateinit var gitRepoAdapter: GitRepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        initGitRepoList()
    }

    private fun initGitRepoList(){

        rvMainGitRepo = findViewById(R.id.rvMainGitRepo)

        gitRepoAdapter = GitRepoAdapter(this)

        rvMainGitRepo.adapter = gitRepoAdapter

        rvMainGitRepo.layoutManager = LinearLayoutManager(this)

        val call: Call<List<GetGitRepoData>> = GithubServiceImpl.service.getRepos("jineeee")

        call.enqueue(
            object : Callback<List<GetGitRepoData>> {
                override fun onFailure(call: Call<List<GetGitRepoData>>, t: Throwable) {
                    Log.e("sopt_git_star", "error: $t")
                }

                override fun onResponse(
                    call: Call<List<GetGitRepoData>>,
                    response: Response<List<GetGitRepoData>>
                ) {
                    if (response.isSuccessful){
                        val gitRepos = response.body()!!

                        gitRepoAdapter.data = gitRepos
                        gitRepoAdapter.notifyDataSetChanged()
                    }
                }
            }
        )

//        gitRepoAdapter.data = listOf(
//            GitRepoItem(
//                title = "SoptStagram",
//                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
//                lang = "Kotlin"
//            ),GitRepoItem(
//                title = "SoptStagram1",
//                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
//                lang = "Kotlin"
//            ),GitRepoItem(
//                title = "SoptStagram2",
//                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
//                lang = "Kotlin"
//            ),GitRepoItem(
//                title = "SoptStagram3",
//                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
//                lang = "Kotlin"
//            )
//        )
//        gitRepoAdapter.notifyDataSetChanged()
    }
}
