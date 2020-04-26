package com.alexey.minay.labs.lab02.dictionary03

import com.alexey.minay.labs.lab02.dictionary03.tests.WordHandler

fun main(args: Array<String>) {
    if (args.isNullOrEmpty()) {
        println("When starting the program, enter the file name")
        return
    }
    val url = args[0]
    val dictionaryReader = DictionaryReader(url, ::println, ::readLine)
    val wordHandler = WordHandler(::println, ::readLine)
    val dictionaryWriter = DictionaryWriter(url, ::println, ::readLine)

    val dictionary = try {
        dictionaryReader.readDictionary()
    } catch (e: RuntimeException) {
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
                dictionaryWriter.close(wordHandler.newWords)
            }
            else -> wordHandler.handle(inputWord.toLowerCase(), dictionary)
        }
    }
}