package com.alexey.minay.lab01.task1.storage

import com.alexey.minay.lab01.task1.logger.LogMessages
import com.alexey.minay.lab01.task1.storage.states.WriterState
import java.io.BufferedWriter
import java.io.File
import java.nio.charset.Charset

class FileTextWriter : TextWriter {

    private var bufferedWriter: BufferedWriter? = null
    private var url: String? = null

    override fun setParams(outputFileUrl: String) {
        if (bufferedWriter == null) {
            bufferedWriter = File(outputFileUrl).bufferedWriter(Charset.forName("Windows-1251"))
        }
        if (url != outputFileUrl) {
            bufferedWriter?.close()
            bufferedWriter = File(outputFileUrl).bufferedWriter(Charset.forName("Windows-1251"))
        }
    }

    override fun saveText(text: String): WriterState {
        try {
            bufferedWriter?.write(text)
        } catch (e: Exception) {
            return WriterState.Error(LogMessages.ERROR_WRITE_FILE)
        }
        return WriterState.Success
    }

    override fun close() {
        bufferedWriter?.close()
    }
}