package com.alexey.minay.labs.lab02.dictionary03.tests

import com.alexey.minay.labs.lab02.dictionary03.DictionaryReader
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import java.lang.RuntimeException

class DictionaryReaderTest {

    private lateinit var dictionaryReader: DictionaryReader

    @Test
    fun shouldReturnNotEmptyDictionary() {
        val dictionary = dictionaryReader.readDictionary()
        assertEquals(3, dictionary.size)
    }

    @Test
    fun shouldReadCorrectWords() {
        val dictionary = dictionaryReader.readDictionary()
        assertEquals("кошка", dictionary["cat"])
        assertEquals("собака", dictionary["dog"])
        assertEquals("дом", dictionary["house"])
    }

    @Test(expected = RuntimeException::class)
    fun shouldThrowExceptionIfFileHasIncorrectData(){
        dictionaryReader = DictionaryReader(getMockIncorrectContentsFile(), { }, { "" })
        dictionaryReader.readDictionary()
    }

    @Before
    fun setUpDictionaryProvider() {
        dictionaryReader = DictionaryReader(getMockDictionaryFilePath(), { }, { "" })
    }

    @After
    fun deleteDictionary(){
        deleteMockFile()
    }
}