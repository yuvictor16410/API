package com.example.apidemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.apidemo.ui.theme.APIDemoTheme
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    // define the specific api based on the api design
    // request, response
    @GET("typicode/demo/profile")
    suspend fun getPost1():PostDetail1

}

data class PostDetail1(
    @SerializedName("name")
    val id: Int,
    val title: String
)




class MainActivity : ComponentActivity() {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var data = ""

        lifecycleScope.launch{

            data class Post1Data(
                var data1: Int,
                var data2: String
            )

            data = api.getPost1().id.toString()
            setContent {
                Screen(data)
            }
        }

    }
}