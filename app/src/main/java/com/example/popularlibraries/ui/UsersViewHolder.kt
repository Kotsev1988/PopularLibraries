package com.example.popularlibraries.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.UserItemBinding
import com.example.popularlibraries.domain.Users
import com.example.popularlibraries.domain.UsersItem

class UsersViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent,false)
) {

private val binding = UserItemBinding.bind(itemView)

    fun bind(users: UsersItem){

        binding.userAvatar.load(users.avatar_url)
        binding.userName.text = users.login
    }

}