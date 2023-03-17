package com.example.popularlibraries.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.domain.Users
import com.example.popularlibraries.domain.UsersItem

class UsersRecyclerAdapter(): RecyclerView.Adapter<UsersViewHolder>() {


    private val data = mutableListOf<UsersItem>()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = getItem(position).id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder = UsersViewHolder(parent)


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = data.size

    private fun getItem(pos: Int): UsersItem = data[pos]

    fun setData(users: List<UsersItem>){

        data.clear()
        data.addAll(users)
        notifyDataSetChanged()

    }
}