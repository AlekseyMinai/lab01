package com.alexey.minay.lab01.task1.storage

import com.alexey.minay.lab01.task1.storage.states.StorageState

interface TextReader {
    fun readChar(inputFileUrl: String, handleResult: (state: StorageState) -> Unit)
}