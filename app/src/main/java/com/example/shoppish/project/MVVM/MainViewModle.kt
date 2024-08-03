package com.example.shoppish.project.MVVM

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val showBottomBar = mutableStateOf(true)
}