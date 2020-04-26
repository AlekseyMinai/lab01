package com.alexey.minay.labs.lab02.dictionary03

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class Application3KtTest {

    private lateinit var dictionaryProvider: DictionaryReader
    private val output = ByteArrayOutputStream()
    private var input = ByteArrayInputStream(byteArrayOf())

    /*@Test
    fun shouldReturnNotEmptyDictionary() {
        val dictionary = dictionaryProvider.readDictionary()
        assert(!dictionary.isNullOrEmpty())
    }

    @Test
    fun shouldPrintTranslateCatIntoRussia() {
        val dictionary = dictionaryProvider.readDictionary()
        dictionaryProvider.handleWord("cat", dictionary)
        assertEquals("Перевод: кошка \n", output.toString())
    }

    @Test
    fun shouldCorrectSaveNewWord() {
        val dictionary = dictionaryProvider.readDictionary()
        provideInput("чашка")
        dictionaryProvider.handleWord("cap", dictionary)
        assertEquals("Слово не найдено, введите перевод: Слово cap сохранено в словаре как: чашка. \n", output.toString())
    }

    @Test
    fun shouldIgnoreNewWordIfInputIsEmpty() {
        val dictionary = dictionaryProvider.readDictionary()
        provideInput("\n")
        dictionaryProvider.handleWord("asdffasdf", dictionary)
        assertEquals("Слово не найдено, введите перевод: Слово проигнорированно. \n", output.toString())
    }

    @Test
    fun shouldSaveNewWord() {
        var dictionary = dictionaryProvider.readDictionary()
        provideInput("чашка")
        dictionaryProvider.handleWord("cap", dictionary)
        provideInput("y")
        dictionaryProvider.close()

        dictionary = dictionaryProvider.readDictionary()
        assert(dictionary.containsKey("cap"))
    }

    @Test
    fun shouldNotSaveNewWord() {
        var dictionary = dictionaryProvider.readDictionary()
        provideInput("чашка")
        dictionaryProvider.handleWord("cap", dictionary)
        provideInput("n")
        dictionaryProvider.close()

        dictionary = dictionaryProvider.readDictionary()
        assertFalse(dictionary.containsKey("cap"))
    }


    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(output))
    }

    @After
    fun restoreSystemInputOutput() {
        input.close()
        output.close()
    }

    private fun provideInput(data: String) {
        input = ByteArrayInputStream(data.toByteArray())
        System.setIn(input)
    }

    @Before
    fun setUpDictionaryProvider() {
        //dictionaryProvider = DictionaryProvider(getMockDictionaryFilePath())
    }

    @After
    fun deleteDictionary() {
        val file = File("testtesttest")
        file.delete()
    }

    private fun getMockDictionaryFilePath(): String {
        val filePath = File("testtesttest")
        filePath.createNewFile()
        val dictionary = mutableMapOf<String, String>()
        dictionary["cat"] = "кошка"
        dictionary["dog"] = "собака"
        dictionary["house"] = "дом"
        dictionary.forEach {
            filePath.appendText(it.key + "=" + it.value + "\n")
        }
        return filePath.path
    }*/

}