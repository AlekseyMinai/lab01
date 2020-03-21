package com.alexey.minay.labs.lab01.replace.storage

import com.alexey.minay.labs.lab01.replace.storage.states.StorageState

interface TextReader {
    fun readChar(inputFileUrl: String, handleResult: (state: StorageState) -> Unit)
}