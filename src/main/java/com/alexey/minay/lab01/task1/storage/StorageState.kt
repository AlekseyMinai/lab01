package com.alexey.minay.lab01.task1.storage

sealed class StorageState {
    class Success(val data: String) : StorageState()
    object Error : StorageState()
}