package com.alexey.minay.labs.lab05.string

import org.junit.Assert.assertEquals
import org.junit.Test

class MyStringTest {

    @Test
    fun shouldAttachTheSameType() {
        val myString = MyString("myString")
        assertEquals(myString, MyString(myString))
    }

    @Test
    fun shouldAttachAnotherType() {
        val myString = MyString(1)
        assertEquals("1", myString.toString())
    }

    @Test
    fun shouldReturnSubString() {
        val myString = MyString("myString")
        assertEquals("my", myString.subString(0, 2).toString())
    }

    @Test
    fun shouldClear() {
        val myString = MyString("myString")
        myString.clear()
        assertEquals("", myString.toString())
    }

    @Test
    fun shouldReturnIterator() {
        val myString = MyString("myString")
        val beginIterator = myString.iterator()
        assertEquals('m', beginIterator.next())
    }

}