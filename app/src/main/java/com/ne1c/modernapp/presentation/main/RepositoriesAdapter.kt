package com.ne1c.modernapp.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ne1c.modernapp.R
import com.ne1c.modernapp.data.network.model.RepositoryModel
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoriesAdapter : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {
    private val items = arrayListOf<RepositoryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]

        with(holder.itemView) {
            nameTextView.text = model.name
            descTextView.text = model.description
            startsTextView.text = model.stars.toString()
            forksTextView.text = model.forks.toString()
            userNameTextView.text = model.owner?.login

            if (!model.language.isNullOrEmpty()) {
                langTextView.visibility = View.VISIBLE
                langTextView.text = model.language
            } else {
                langTextView.visibility = View.GONE
            }

            Glide.with(this)
                    .load(model.owner?.avatarUrl)
                    .into(avatarImageView)
        }
    }

    override fun getItemCount(): Int = items.size

    fun setData(data: ArrayList<RepositoryModel>) {
        items.clear()
        items.addAll(data)

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}