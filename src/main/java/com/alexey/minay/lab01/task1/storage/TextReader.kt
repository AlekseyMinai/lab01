package com.alexey.minay.lab01.task1.storage

interface TextReader {
    fun read(inputFileUrl: String, handleResult: (state: StorageState) -> Unit)
}