package com.example.popularlibraries

import android.app.Application
import android.content.Context
import com.example.popularlibraries.data.UserRepoImpl
import com.example.popularlibraries.data.net.GitUsersAPIClient
import com.example.popularlibraries.domain.UserRepo

class App: Application() {



}
val Context.app
    get() = applicationContext as App