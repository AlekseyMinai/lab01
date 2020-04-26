package com.alexey.minay.labs.lab02.dictionary03

import java.io.File

class DictionaryWriter(
        private val url: String,
        private val output: (value: String) -> Unit,
        private val input: () -> String?
) {

    fun close(newWords: Map<String, String>) {
        output.invoke("В словарь были внесены изменения. Сохранить Y/N?")
        var isIncorrectInput = true
        while (isIncorrectInput) {
            when (input.invoke()?.toLowerCase()) {
                "y" -> {
                    saveNewWords(newWords)
                    isIncorrectInput = false
                }
                "n" -> isIncorrectInput = false
                else -> output.invoke("Некорректная команда, введите y или n.")
            }
        }
    }

    private fun saveNewWords(newWords: Map<String, String>) {
        val dictionaryFile = File(url)
        newWords.forEach {
            dictionaryFile.appendText(it.key + "=" + it.value + "\n")
        }
    }
}