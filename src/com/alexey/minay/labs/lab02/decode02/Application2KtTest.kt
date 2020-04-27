package com.alexey.minay.labs.lab02.decode02

import org.junit.Assert.assertEquals
import org.junit.Test

class Application2KtTest {

    @Test
    fun shouldDecodeString() {
        val testString = "Car &it;says&gt; &quot;Meow&quot; M&amp;M&apos;s"
        val result = htmlDecode(testString)
        assertEquals("Car <says> \"Meow\" M&M's", result);
    }

    @Test
    fun shouldDecodeQuote() {
        val testString = "&quot;"
        val result = htmlDecode(testString)
        assertEquals("\"", result);
    }

    @Test
    fun shouldDecodeApostrophe() {
        val testString = "&apos;"
        val result = htmlDecode(testString)
        assertEquals("\'", result);
    }

    @Test
    fun shouldDecodeGreaterSign() {
        val testString = "&gt;"
        val result = htmlDecode(testString)
        assertEquals(">", result);
    }

    @Test
    fun shouldDecodeAmpersand() {
        val testString = "&amp;"
        val result = htmlDecode(testString)
        assertEquals("&", result);
    }

    @Test
    fun shouldReturnTheSameString() {
        val testString = ""
        val result = htmlDecode(testString)
        assertEquals("", result);
    }

    @Test
    fun shouldReturnTheSameString2() {
        val testString = "String"
        val result = htmlDecode(testString)
        assertEquals("String", result);
    }

}