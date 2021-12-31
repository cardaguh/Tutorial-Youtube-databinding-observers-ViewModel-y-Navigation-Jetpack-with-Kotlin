package com.example.databindingejemplo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val changeCount = MutableLiveData<Int>()
    val navigateSecond = MutableLiveData<Boolean>()

    init {
      changeCount.value = 0
    }

    fun addNumber() {
        changeCount.value = (changeCount.value)?.plus(1)
    }

    fun goSecond() {
        navigateSecond.value = true
    }
}