package com.alexey.minay.lab01.task1.storage

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

    override fun saveText(text: String) {
        try {
            bufferedWriter?.write(text)
        } catch (e: Exception) {

        }
    }

    override fun close() {
        bufferedWriter?.close()
    }
}