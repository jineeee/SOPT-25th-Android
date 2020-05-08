package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMainGitRepo: RecyclerView
    private lateinit var gitRepoAdapter: GitRepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initGitRepoList()
    }

//    private fun initGitRepoList(){
//
//        rvMainGitRepo = findViewById(R.id.rvMainGitRepo)
//
//        gitRepoAdapter = GitRepoAdapter(this)
//
//        rvMainGitRepo.adapter = gitRepoAdapter
//
//        rvMainGitRepo.layoutManager = LinearLayoutManager(this)
//    }
}
