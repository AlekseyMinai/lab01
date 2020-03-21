package com.alexey.minay.labs.lab01.task1.storage

import com.alexey.minay.labs.lab01.task1.logger.LogMessages
import com.alexey.minay.labs.lab01.task1.storage.states.WriterState
import java.io.BufferedWriter
import java.io.File
import java.nio.charset.Charset

class FileTextWriter : TextWriter {

    private var bufferedWriter: BufferedWriter? = null
    private var url: String? = null
    private var wasError = false

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
            wasError = true
            return WriterState.Error(LogMessages.ERROR_WRITE_FILE)
        }
        return WriterState.Success
    }

    override fun close(): WriterState {
        bufferedWriter?.close()
        if (wasError) {
            return WriterState.Finished(LogMessages.FINISHED_WITH_ERROR_WRITE_FILE)
        }
        return WriterState.Finished(LogMessages.FINISHED_WITH_SUCCESS_WRITE_FILE)
    }
}