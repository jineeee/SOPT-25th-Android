package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        gitRepoAdapter.data = listOf(
            GitRepoItem(
                title = "SoptStagram",
                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                lang = "Kotlin"
            ),GitRepoItem(
                title = "SoptStagram1",
                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                lang = "Kotlin"
            ),GitRepoItem(
                title = "SoptStagram2",
                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                lang = "Kotlin"
            ),GitRepoItem(
                title = "SoptStagram3",
                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                lang = "Kotlin"
            )
        )
        gitRepoAdapter.notifyDataSetChanged()
    }
}
