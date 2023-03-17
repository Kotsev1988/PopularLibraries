package com.example.popularlibraries.data.net

import com.example.popularlibraries.domain.Users
import com.example.popularlibraries.domain.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface GitUsersAPI {

    @GET("users")
    fun getUsers(): Call<Users>


}