package com.example.restapi.remote

import com.example.restapi.pojo.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/users")
    fun getAllUsers(): Call<List<User>>



}