package com.example.apidemo.network

import com.google.gson.annotations.SerializedName

data class Database(
    @SerializedName("posts")
    val posts: List<Post>,
    @SerializedName("comments")
    val comments: List<Comment>,
    @SerializedName("profile")
    val profile: Profile
){
    data class Profile(
        @SerializedName("name")
        val name: String
    )

    data class Post(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String
    )

    data class Comment(
        @SerializedName("id")
        val id: Int,
        @SerializedName("body")
        val body: String,
        @SerializedName("postId")
        val postId: Int
    )
}

