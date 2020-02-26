package com.alexey.minay.lab01.task1.storage

import com.alexey.minay.lab01.task1.logger.LogMessages
import com.alexey.minay.lab01.task1.storage.states.WriterState
import java.io.BufferedWriter
import java.io.File

class FileTextWriter : TextWriter {

    private var bufferedWriter: BufferedWriter? = null
    private var url: String? = null

    override fun setParams(outputFileUrl: String) {
        if (bufferedWriter == null) {
            bufferedWriter = File(outputFileUrl).bufferedWriter()
        }
        if (url != outputFileUrl) {
            bufferedWriter?.close()
            bufferedWriter = File(outputFileUrl).bufferedWriter()
        }
    }

    override fun saveText(text: String): WriterState {
        try {
            bufferedWriter?.write(text)
            bufferedWriter?.append("\n")
        } catch (e: Exception) {
            return WriterState.Error(LogMessages.ERROR_WRITE_FILE)
        }
        return WriterState.Success
    }

    override fun close() {
        bufferedWriter?.close()
    }
}