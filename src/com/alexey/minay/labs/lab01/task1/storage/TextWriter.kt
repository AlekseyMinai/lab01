package com.alexey.minay.labs.lab01.task1.storage

import com.alexey.minay.labs.lab01.task1.storage.states.WriterState

interface TextWriter {
    fun setParams(outputFileUrl: String)
    fun saveText(text: String): WriterState
    fun close(): WriterState
}