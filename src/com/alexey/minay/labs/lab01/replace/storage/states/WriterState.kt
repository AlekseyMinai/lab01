package com.alexey.minay.labs.lab01.replace.storage.states

sealed class WriterState {
    object Success : WriterState()
    class Finished(val message: String) : WriterState()
    class Error(val message: String) : WriterState()
}