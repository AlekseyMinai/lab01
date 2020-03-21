package com.alexey.minay.labs.lab01.replace.storage.states

sealed class StorageState {
    class Success(val char: Char) : StorageState()
    class Error(val message: String) : StorageState()
    object Closed : StorageState()
}