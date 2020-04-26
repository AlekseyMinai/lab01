package com.alexey.minay.labs.lab02.dictionary03

import com.alexey.minay.labs.lab02.dictionary03.tests.WordHandler
import com.alexey.minay.labs.lab02.dictionary03.tests.deleteMockFile
import com.alexey.minay.labs.lab02.dictionary03.tests.getMockDictionary
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WordHandlerTest {

    private lateinit var wordHandler: WordHandler
    private var mockOutput: String = ""
    private var mockInput: String = ""

    @Test
    fun shouldPrintTranslateCatIntoRussia() {
        val dictionary = getMockDictionary()
        wordHandler.handle("cat", dictionary)
        assertEquals("Перевод: кошка ", mockOutput)
    }

    @Test
    fun shouldCorrectSaveNewWord() {
        val dictionary = getMockDictionary()
        mockInput = "чашка"
        wordHandler.handle("cup", dictionary)
        assertEquals("Слово cap сохранено в словаре как: чашка.", mockOutput)
        assertEquals("чашка", wordHandler.newWords["cup"])
    }

    @Test
    fun shouldIgnoreNewWordIfInputIsEmpty() {
        val dictionary = getMockDictionary()
        mockInput = "\n"
        wordHandler.handle("asdffasdf", dictionary)
        assertEquals("Слово проигнорированно.", mockOutput)
        assertEquals(null, wordHandler.newWords["asdffasdf"])
    }

    @Before
    fun setUpDictionaryProvider() {
        wordHandler = WordHandler({ mockOutput = it }, { mockInput })
        mockInput = ""
        mockOutput = ""
    }

    @After
    fun deleteDictionary() {
        deleteMockFile()
    }
}