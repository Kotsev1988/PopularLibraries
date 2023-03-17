package com.example.popularlibraries

import com.example.popularlibraries.data.UserRepoImpl
import com.example.popularlibraries.data.net.GitUsersAPIClient
import com.example.popularlibraries.domain.UserRepo
import com.example.popularlibraries.domain.UsersView

class UsersPresenter(private val usersView: UsersView) {
    private val userRepo: UserRepo by lazy { UserRepoImpl(GitUsersAPIClient()) }

    fun showUsers(){
        usersView.onLoad()

        userRepo.getUsers(

            onSuccess = {
                usersView.usersList(it)
                usersView.hideLoad()
            },
            onError = {

                usersView.onError(Throwable("Error"))
            }

        )
    }
}