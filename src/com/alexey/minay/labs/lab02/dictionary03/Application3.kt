package com.alexey.minay.labs.lab02.dictionary03

import java.io.File

fun main(args: Array<String>) {
    if (args.isNullOrEmpty()){
        println("When starting the program, enter the file name")
        return
    }
    val url = args[0]
    val dictionaryProvider = DictionaryProvider(url, ::println, ::readLine)
    val dictionary = try {
        dictionaryProvider.readDictionary()
    }catch (e: RuntimeException){
        println(e.message)
        return
    }
    var isResumed = true
    while (isResumed) {
        print("Введите слово для перевода: ")
        val inputWord = readLine()
        if (inputWord.isNullOrBlank()) {
            println("Некорректный ввод.")
            continue
        }
        when (inputWord) {
            "..." -> {
                isResumed = false
                dictionaryProvider.close()
            }
            else -> dictionaryProvider.handleWord(inputWord.toLowerCase(), dictionary)
        }
    }
}

class DictionaryProvider(
        private val url: String,
        private val output: (value: String) -> Unit,
        private val input: () -> String?
) {

    private val newWords = mutableMapOf<String, String>()

    fun readDictionary(): Map<String, String> {
        val dictionaryFile = getFile(url)
        val dictionary = mutableMapOf<String, String>()
        dictionaryFile.forEachLine{line ->
            val splittedLine = line.split("=")
            if (splittedLine.size != 2){
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

    fun handleWord(inputWord: String?, dictionary: Map<String, String>) {
        var translate = dictionary[inputWord]
        if (translate.isNullOrBlank()) {
            translate = newWords[inputWord]
            if (translate.isNullOrBlank()) {
                startAddCase(inputWord)
                return
            }
        }
        output.invoke("Перевод: $translate ")
    }

    private fun startAddCase(inputWord: String?) {
        output.invoke("Слово не найдено, введите перевод: ")
        val translate = input.invoke()
        if (translate.isNullOrBlank()) {
            output.invoke("Слово проигнорированно.")
        } else {
            if (inputWord != null) newWords[inputWord] = translate
            output.invoke("Слово $inputWord сохранено в словаре как: $translate.")
        }
    }

    fun close() {
        output.invoke("В словарь были внесены изменения. Сохранить Y/N?")
        var isIncorrectInput = true
        while (isIncorrectInput) {
            when (input.invoke()?.toLowerCase()) {
                "y" -> {
                    saveNewWords()
                    isIncorrectInput = false
                }
                "n" -> isIncorrectInput = false
                else -> output.invoke("Некорректная команда, введите y или n.")
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