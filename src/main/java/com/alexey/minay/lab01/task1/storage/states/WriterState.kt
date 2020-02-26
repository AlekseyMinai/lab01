package com.alexey.minay.lab01.task1.storage.states

sealed class WriterState {
    object Success : WriterState()
    class Error(val message: String) : WriterState()
}