package com.ne1c.modernapp.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ne1c.modernapp.R
import com.ne1c.modernapp.data.network.model.RepositoryModel

class RepositoriesAdapter(items: ArrayList<RepositoryModel>)
    : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun getItemCount(): Int = 10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}