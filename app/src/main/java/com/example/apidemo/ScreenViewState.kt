package com.example.apidemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ScreenViewState {

    private var _binding : ScreenViewBinding by mutableStateOf(
        ScreenViewBinding.Loading

    )
    val binding: ScreenViewBinding get() = _binding

    fun moveToTarget(target: ScreenViewBinding){
        _binding = target
    }
}