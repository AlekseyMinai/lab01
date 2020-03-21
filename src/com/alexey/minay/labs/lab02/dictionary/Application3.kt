package com.alexey.minay.labs.lab02.dictionary

import java.io.File

fun main() {
    val dictionaryProvider = DictionaryProvider("/home/user/labs/oop-master/tasks/dic")
    val dictionary = dictionaryProvider.readDictionary()
    var isResumed = true
    while (isResumed) {
        print("Введите слово для перевода: ")
        val inputWord = readLine()
        if(inputWord.isNullOrBlank()){
            print("Некорректный ввод. \n")
            continue
        }
        when (inputWord) {
            "..." -> {
                isResumed = false
                dictionaryProvider.close()
            }
            else -> dictionaryProvider.handleWord(inputWord, dictionary)
        }
    }
}


class DictionaryProvider(private val url: String) {

    private val newWords = mutableMapOf<String, String>()

    fun readDictionary(): Map<String, String> {
        val dictionaryFile = getFile(url)
        val bufferedReader = dictionaryFile.bufferedReader()
        val iterator = bufferedReader.lineSequence().iterator()
        val dictionary = mutableMapOf<String, String>()
        while (iterator.hasNext()) {
            val line = iterator.next()
            val splittedLine = line.split("=")
            dictionary[splittedLine[0]] = splittedLine[1]
        }
        bufferedReader.close()
        return dictionary
    }

    private fun getFile(url: String): File {
        val file = File(url)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    fun handleWord(inputWord: String?, dictionary: Map<String, String>) {
        var translate = dictionary[inputWord]
        if (translate.isNullOrBlank()) {
            translate = newWords[inputWord]
            if (translate.isNullOrBlank()) {
                startAddCase(inputWord)
                return
            }
        }
        print("Перевод: $translate \n")
    }

    private fun startAddCase(inputWord: String?) {
        print("Слово не найдено, введите перевод: ")
        val translate = readLine()
        if (translate.isNullOrBlank()) {
            print("Слово проигнорированно. \n")
        } else {
            if (inputWord != null) newWords[inputWord] = translate
            print("Слово $inputWord сохранено в словаре как: $translate. \n")
        }
    }

    fun close() {
        print("В словарь были внесены изменения. Сохранить Y/N? ")
        var isIncorrectInput = true
        while (isIncorrectInput) {
            when (readLine()?.toLowerCase()) {
                "y" -> {
                    saveNewWords()
                    isIncorrectInput = false
                }
                "n" -> isIncorrectInput = false
                else -> print("Некорректная команда, введите y или n. ")
            }
        }
    }

    private fun saveNewWords() {
        val dictionaryFile = File(url)
        newWords.forEach {
            dictionaryFile.appendText(it.key + "=" + it.value + "\n")
        }
    }
}