package com.alexey.minay.labs.lab02.dictionary03.tests

import java.io.File

fun getMockDictionary(): MutableMap<String, String>{
    val dictionary = mutableMapOf<String, String>()
    dictionary["cat"] = "кошка"
    dictionary["dog"] = "собака"
    dictionary["house"] = "дом"
    return dictionary
}

fun getMockDictionaryFilePath(): String {
    val filePath = File("testtesttest")
    filePath.createNewFile()
    getMockDictionary().forEach {
        filePath.appendText(it.key + "=" + it.value + "\n")
    }
    return filePath.path
}

fun getMockIncorrectContentsFile(): String {
    val filePath = File("testtesttest")
    filePath.createNewFile()
    filePath.appendText("asdf")
    return filePath.path
}

fun deleteMockFile() {
    val file = File("testtesttest")
    file.delete()
}