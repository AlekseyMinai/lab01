package com.alexey.minay.labs.lab05.string

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class UtilKtTest {

    @Test
    fun shouldConcatenateMyStringWithMyString() {
        val myString1 = MyString("my")
        val myString2 = MyString("String")
        val result = myString1 + myString2
        assertEquals("myString", result.toString())
    }

    @Test
    fun shouldConcatenateMyStringWithString() {
        val myString = MyString("my")
        val string = "String"
        val result = myString + string
        assertEquals("myString", result.toString())
    }

    @Test
    fun shouldConcatenateCharWithMyString() {
        val char = 'm'
        val myString = MyString("yString")
        val result = char + myString
        assertEquals("myString", result.toString())
    }

    @Test
    fun shouldConcatenateWithAttach() {
        var myString1 = MyString("my")
        val myString2 = MyString("String")
        myString1 += myString2
        assertEquals("myString", myString1.toString())
    }

    @Test
    fun shouldEquals() {
        val myString1 = MyString("String")
        val myString2 = MyString("String")
        assert(myString1 == myString2)
    }

    @Test
    fun shouldNotEquals() {
        val myString1 = MyString("my")
        val myString2 = MyString("String")
        assert(myString1 != myString2)
    }

    @Test
    fun shouldCompareAlphabetically1() {
        val myString1 = MyString("my")
        val myString2 = MyString("String")
        assert(myString1 > myString2)
    }

    @Test
    fun shouldCompareAlphabetically2() {
        val myString1 = MyString("my")
        val myString2 = MyString("String")
        assertFalse(myString1 < myString2)
    }

    @Test
    fun shouldCompareAlphabetically3() {
        val myString1 = MyString("my")
        val myString2 = MyString("String")
        assertFalse(myString1 <= myString2)
    }

    @Test
    fun shouldCompareAlphabetically4() {
        val myString1 = MyString("my")
        val myString2 = MyString("String")
        assert(myString1 >= myString2)
    }

    @Test
    fun shouldGetByIndex() {
        val myString = MyString("my")
        assertEquals('y', myString[1])
    }

    @Test
    fun shouldSetByIndex() {
        val myString = MyString("my")
        myString[1] = 'm'
        assertEquals('m', myString[1])
    }

}