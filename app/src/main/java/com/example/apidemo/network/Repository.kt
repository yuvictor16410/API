package com.example.apidemo.network

import com.example.apidemo.ScreenViewBinding

class Repository {

    private val api = NetworkingInteractor.api

    suspend fun getAllInfo(): ScreenViewBinding.Content {
        val dto = api.getDB()
        val content =
            ScreenViewBinding.Content(
                posts = dto.posts,
                comments = dto.comments,
                profile = dto.profile
            )
        return content
    }

    suspend fun getProfile(): ScreenViewBinding.ProfileView{
        val dto = api.getDB()
        val content =
            ScreenViewBinding.ProfileView(
                profile = dto.profile
            )
        return content
    }
}