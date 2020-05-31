package com.alexey.minay.labs.lab02.dictionary03.tests

import com.alexey.minay.labs.lab02.dictionary03.DictionaryReader
import com.alexey.minay.labs.lab02.dictionary03.DictionaryWriter
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class DictionaryWriterTest {

    private lateinit var dictionaryWriter: DictionaryWriter
    private lateinit var dictionaryReader: DictionaryReader
    private var mockOutput: String = ""
    private var mockInput: String = ""

    @Test
    fun shouldWriteNewWordInFile() {
        val newWords = mapOf(Pair("cup", "чашка"))
        mockInput = "y"
        dictionaryWriter.close(newWords)
        val dictionary = dictionaryReader.readDictionary()
        assert(dictionary.containsKey("cup"))
    }

    @Test
    fun shouldNotSaveNewWordIfUserRefused() {
        val newWords = mapOf(Pair("cup", "чашка"))
        mockInput = "n"
        dictionaryWriter.close(newWords)
        val dictionary = dictionaryReader.readDictionary()
        assertFalse(dictionary.containsKey("cup"))
    }


    @Before
    fun setUpDictionaryProvider() {
        dictionaryWriter = DictionaryWriter(getMockDictionaryFilePath(), { mockOutput = it }, { mockInput })
        dictionaryReader = DictionaryReader(getMockDictionaryFilePath())
    }

    @After
    fun deleteDictionary() {
        deleteMockFile()
    }

}