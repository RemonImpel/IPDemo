package com.example.ipdemo.Helpers

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class NotificationStateController : ViewModel() {
    private var _state: MutableStateFlow<Boolean> = MutableStateFlow(false)

    var notificationState = _state

    fun setState(s: Boolean) {
        _state.value = s
    }

}