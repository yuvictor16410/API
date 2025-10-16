package com.example.apidemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Screen(binding: ScreenViewBinding){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = binding.ButtonState.onClick
        ){ Text(binding.ButtonState.text) }

        when(binding){
            is ScreenViewBinding.Loading -> {
                CircularProgressIndicator()
            }

            is ScreenViewBinding.ProfileView -> {
                binding.profile.name
            }

            is ScreenViewBinding.Content -> {

                binding.posts.forEach {
                    Text(text = it.id.toString(), fontSize = 20.sp, color = Color.Black)
                    Text(text = it.title, fontSize = 20.sp, color = Color.Black)
                }

                binding.comments.forEach{
                    Text(text = it.id.toString(), fontSize = 20.sp, color = Color.Black)
                    Text(text = it.body, fontSize = 20.sp, color = Color.Black)
                    Text(text = it.postId.toString(), fontSize = 20.sp, color = Color.Black)
                }

                Text(text = binding.profile.name, fontSize = 20.sp, color = Color.Black)
            }
        }



    }
}

@Composable
@Preview
fun Screen_Preview(){


}