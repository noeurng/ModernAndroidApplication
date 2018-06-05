package com.ne1c.modernapp.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ne1c.modernapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reposRecyclerView.layoutManager = LinearLayoutManager(this)
        reposRecyclerView.adapter = RepositoriesAdapter(arrayListOf())
    }
}
