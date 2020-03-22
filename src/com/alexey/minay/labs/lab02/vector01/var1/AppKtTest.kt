package com.alexey.minay.labs.lab02.vector01.var1

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class AppKtTest {

    private val output = ByteArrayOutputStream()
    private var input = ByteArrayInputStream(byteArrayOf())

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

    @Test
    fun appCase() {
        val testString = "1 2 3"
        val info = "Введите числа с плавающей точкой, разделенные пробелами:"
        provideInput(testString)
        main()
        assertEquals("$info\n3.0 4.0 5.0 ", output.toString());
    }

    @Test
    fun shouldReadStringAndReturnListOfDouble() {
        val testString = "1 2 3"
        provideInput(testString)
        val listDouble = readIn()
        assertEquals(mutableListOf(1.0, 2.0, 3.0), listDouble)
    }

    @Test
    fun stringShouldMapToDoubleList() {
        val str = "1 2 3 4"
        assertEquals(mutableListOf(1.0, 2.0, 3.0, 4.0), str.toDoubleList())
    }

    @Test
    fun shouldNotReadNotNumber() {
        val str = "1 a 3 4"
        val listDouble = str.toDoubleList()
        assertEquals(mutableListOf(1.0, 3.0, 4.0), listDouble)
    }

    @Test
    fun shouldPrintError() {
        val str = "1 a 3 4"
        str.toDoubleList()
        assertEquals("\"a\" - не число \n", output.toString());
    }

    @Test
    fun shouldAverageToOnlyPositiveNumbers() {
        val listDouble = mutableListOf(1.0, 2.0, -9.0)
        assertEquals(mutableListOf(-1.0, 0.0, -9.0), listDouble.addAverageToPositiveValue())
    }

    @Test
    fun shouldRoundTo3Char() {
        val p = 3.14159265358
        assertEquals(3.142, p.roundTo3Char(), 0.0001)
    }

}