package com.alexey.minay.lab01.task1.storage.states

sealed class StorageState {
    class Success(val data: String) : StorageState()
    class Error(val message: String) : StorageState()
    object Closed : StorageState()
}