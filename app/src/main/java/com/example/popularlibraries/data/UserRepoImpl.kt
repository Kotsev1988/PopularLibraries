package com.example.popularlibraries.data

import com.example.popularlibraries.data.net.GitUsersAPIClient
import com.example.popularlibraries.domain.GitUsers
import com.example.popularlibraries.domain.UserRepo
import com.example.popularlibraries.domain.Users
import com.example.popularlibraries.domain.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepoImpl(private val retrofitClient: GitUsersAPIClient): UserRepo {

    override fun getUsers(onSuccess: (Users) -> Unit, onError: (Throwable) -> Unit) {

        retrofitClient.getListOfUsers().enqueue(object : Callback<Users>{
            override fun onResponse(call: Call<Users>, response: Response<Users>) {

                if (response.isSuccessful){
                    response.body()?.let { onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                onError(Throwable("Error"))
            }



        })

    }


}