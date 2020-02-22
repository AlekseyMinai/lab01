package com.alexey.minay.lab01.task1.storage

interface TextWriter {
    fun setParams(outputFileUrl: String)
    fun saveText(text: String)
    fun close()
}