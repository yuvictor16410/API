package com.example.apidemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apidemo.network.Repository
import kotlinx.coroutines.launch

class ScreenViewModel: ViewModel() {

    val viewState = ScreenViewState()

    init {
        val repository = Repository()

        //suspend method cannot be used in main thread
        viewModelScope.launch{
            val content = repository.getAllInfo()
            viewState.moveToTarget(content)
        }

    }

    fun onButtonClicked(){
        val repository = Repository()

        viewModelScope.launch{
            val content = repository.getProfile()
            viewState.moveToTarget(content)
        }
    }

}