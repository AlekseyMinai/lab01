package com.alexey.minay.labs.lab01.task1.storage

import com.alexey.minay.labs.lab01.task1.logger.LogMessages
import com.alexey.minay.labs.lab01.task1.storage.states.StorageState
import java.io.BufferedReader
import java.io.File
import java.nio.charset.Charset

class FileTextReader : TextReader {

    override fun readChar(inputFileUrl: String, handleResult: (state: StorageState) -> Unit) {
        var bufferedReader: BufferedReader? = null
        try {
            bufferedReader = File(inputFileUrl).bufferedReader(Charset.forName("Windows-1251"))
            var symbol = bufferedReader.read()
            while (symbol != -1) {
                handleResult(StorageState.Success(symbol.toChar()))
                symbol = bufferedReader.read()
            }
        } catch (e: Exception) {
            handleResult(StorageState.Error(LogMessages.ERROR_READ_FILE))
        } finally {
            bufferedReader?.close()
            handleResult(StorageState.Closed)
        }
    }

}