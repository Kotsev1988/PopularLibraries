package com.example.popularlibraries.domain

interface UserRepo {

    fun getUsers(
        onSuccess: (Users) ->Unit,
        onError: (Throwable) ->Unit
    )

}