package com.alexey.minay.labs.lab02.vector.var1

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class AppKtTest {

    private val output = ByteArrayOutputStream()

    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(output))
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
        val listDouble = str.toDoubleList()
        assertEquals("\"a\" - не число \n", output.toString());
    }

    @Test
    fun shouldAverageToOnlyPositiveNumbers(){
        val listDouble = mutableListOf(1.0, 2.0, -9.0)
        assertEquals(mutableListOf(-1.0, 0.0, -9.0), listDouble.addAverageToPositiveValue())
    }

    @Test
    fun shouldRoundTo3Char(){
        val p = 3.14159265358
        assertEquals(3.142, p.roundTo3Char(), 0.0001)
    }

}