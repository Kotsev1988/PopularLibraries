package com.example.popularlibraries.data.net

import com.example.popularlibraries.domain.Users
import com.example.popularlibraries.domain.UsersItem
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class GitUsersAPIClient {

    private val baseURL = "https://api.github.com/"

    private fun apiGitRetrofit(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            ))
            .client(createOkHttpClient(GitApiInterceptor()))
            .build()
    }

    private val serviceApi: GitUsersAPI = apiGitRetrofit(baseURL).create(GitUsersAPI::class.java)

    fun getListOfUsers(): Call<Users>{
        return serviceApi.getUsers()
    }


    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        return httpClient.build()
    }

    inner class GitApiInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            return chain.proceed(chain.request())
        }
    }
}