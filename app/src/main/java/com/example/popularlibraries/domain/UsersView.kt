package com.example.popularlibraries.domain

import com.example.popularlibraries.domain.Users

interface UsersView {

    fun usersList(users: Users)
    fun onError(e: Throwable)
    fun onLoad()
    fun hideLoad()
}