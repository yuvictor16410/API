package com.example.apidemo.network

import com.example.apidemo.network.Database.Comment
import com.example.apidemo.network.Database.Post
import retrofit2.http.GET

interface ApiDao {

    // define the specific api based on the api design
    // request, response
    @GET("typicode/demo/profile")
    suspend fun getProfile(): Database.Profile

    @GET("typicode/demo/posts")
    suspend fun getPosts(): List<Post>

    @GET("typicode/demo/comments")
    suspend fun getComments(): List<Comment>

    @GET("typicode/demo/db")
    suspend fun getDB(): Database
}