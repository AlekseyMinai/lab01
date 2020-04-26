package com.alexey.minay.labs.lab07.findmax

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilKtTest {

    @Test
    fun shouldFindMaxDouble() {
        var maxDouble: Double = Double.NaN
        val maxDoubleSetter: (maxValue: Double) -> Unit = { maxDouble = it }
        val listDouble = mutableListOf(1.0, 2.0, 333.0, 3.0, 4.0, 5.0, 6.0, -532.0, 5.0)
        findMax(listDouble, maxDoubleSetter)
        assertEquals(333.0, maxDouble, 0.0001)
    }

    @Test
    fun shouldFindMaxString() {
        var maxString: String = ""
        val maxStringSetter: (maxValue: String) -> Unit = { maxString = it }
        val listString = mutableListOf("ss", "aa", "asd")
        findMax(listString, maxStringSetter)
        assertEquals("ss", maxString)
    }

    @Test
    fun shouldFindMaxChar() {
        var maxChar: Char? = null
        val maxCharSetter: (maxValue: Char) -> Unit = { maxChar = it }
        val listChar = mutableListOf('a', 'r', 'd')
        findMax(listChar, maxCharSetter)
        assertEquals('r', maxChar)
    }

}