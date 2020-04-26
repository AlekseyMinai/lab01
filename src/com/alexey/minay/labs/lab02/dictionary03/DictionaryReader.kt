package com.alexey.minay.labs.lab02.dictionary03

import java.io.File

class DictionaryReader(
        private val url: String,
        private val output: (value: String) -> Unit,
        private val input: () -> String?
) {

    fun readDictionary(): Map<String, String> {
        val dictionaryFile = getFile(url)
        val dictionary = mutableMapOf<String, String>()
        dictionaryFile.forEachLine { line ->
            val splittedLine = line.split("=")
            if (splittedLine.size != 2) {
                throw RuntimeException("Invalid file contents")
            }
            dictionary[splittedLine[0]] = splittedLine[1]
        }
        return dictionary
    }

    private fun getFile(url: String): File {
        val file = File(url)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }
}