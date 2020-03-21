package com.alexey.minay.labs.lab02.decode

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Application2KtTest{

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
        val testString = "Car &it;says&gt; &quot;Meow&quot; M&amp;M&apos;s"
        val info = "введите закодированную строку:"
        provideInput(testString)
        main()
        assertEquals(info + "Car <says> \"Meow\" M&M's", output.toString());
    }

}