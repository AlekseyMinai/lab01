package com.alexey.minay.lab01.task1.storage.states

sealed class WriterState {
    class Success(val message: String) : WriterState()
    class Error(val message: String) : WriterState()
}