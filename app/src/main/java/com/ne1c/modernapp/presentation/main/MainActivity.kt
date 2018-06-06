package com.ne1c.modernapp.presentation.main

import android.arch.lifecycle.Observer
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ne1c.modernapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.indeterminateDrawable.setColorFilter(resources.getColor(R.color.colorAccent2), PorterDuff.Mode.SRC_IN)

        reposRecyclerView.layoutManager = LinearLayoutManager(this)
        reposRecyclerView.adapter = RepositoriesAdapter()

        viewModel.topRepositories.observe(this, Observer {
            reposRecyclerView.visibility = View.VISIBLE
            (reposRecyclerView.adapter as RepositoriesAdapter).setData(it!!)
        })

        viewModel.loadingStatus.observe(this, Observer {
            progressBar.visibility = if (checkNotNull(it)) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.start()
    }
}
