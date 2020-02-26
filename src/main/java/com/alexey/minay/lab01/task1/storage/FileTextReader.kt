package com.alexey.minay.lab01.task1.storage

import com.alexey.minay.lab01.task1.logger.LogMessages
import com.alexey.minay.lab01.task1.storage.states.StorageState
import java.io.BufferedReader
import java.io.File

class FileTextReader : TextReader {

    override fun read(inputFileUrl: String, handleResult: (state: StorageState) -> Unit) {
        var bufferedReader: BufferedReader? = null
        try {
            bufferedReader = File(inputFileUrl).bufferedReader()
            bufferedReader.forEachLine { line ->
                handleResult(StorageState.Success(line))
            }
        } catch (e: Exception) {
            handleResult(StorageState.Error(LogMessages.ERROR_READ_FILE))
        } finally {
            bufferedReader?.close()
            handleResult(StorageState.Closed)
        }
    }

}