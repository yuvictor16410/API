package com.example.apidemo


import com.example.apidemo.network.Database.Comment
import com.example.apidemo.network.Database.Post
import com.example.apidemo.network.Database.Profile


sealed interface ScreenViewBinding {

    data object Loading: ScreenViewBinding

    data class Content(
        val posts: List<Post>,
        val comments: List<Comment>,
        val profile: Profile
    ) : ScreenViewBinding

    data class ButtonState(
        val text : String,
        val onClick: () -> Unit
    )

    data class ProfileView(
        val profile: Profile
    ) : ScreenViewBinding

}