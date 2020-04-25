package com.alexey.minay.labs.lab07.myarray

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyArrayTest {

    private var mMyArray = MyArray<Double>()

    @Before
    fun setUp() {
        mMyArray = MyArray()
    }

    @Test
    fun shouldAddElements() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        assertEquals(3, mMyArray.size())
        assertEquals(2.0, mMyArray[2], 0.0001)
    }

    @Test
    fun shouldResize() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        mMyArray.resize(20)
        assertEquals(2.0, mMyArray[2], 0.0001)
        assertEquals(20, mMyArray.capacity)
    }

    @Test
    fun shouldClear() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        mMyArray.clear()
        assertEquals(0, mMyArray.size())
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun shouldThrowException() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        mMyArray[3]
    }

    @Test
    fun shouldReturnNextValue() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        val iterator = mMyArray.begin()
        assertEquals(0.0, iterator.next(), 0.0001)
        assertEquals(1.0, iterator.next(), 0.0001)
        assertEquals(2.0, iterator.next(), 0.0001)
    }

    @Test
    fun shouldReturnPreviousValue() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        val iterator = mMyArray.end()
        assertEquals(2.0, iterator.previous(), 0.0001)
        assertEquals(1.0, iterator.previous(), 0.0001)
        assertEquals(0.0, iterator.previous(), 0.0001)
    }

    @Test(expected = NoSuchElementException::class)
    fun shouldNoReturnNextElement() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        val iterator = mMyArray.end()
        iterator.next()
    }

    @Test
    fun shouldAddIntoCurrentPosition() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        val iterator = mMyArray.begin()
        iterator.next()
        iterator.next()
        iterator.add(22.0)
        assertEquals(22.0, mMyArray[1], 0.0001)
    }

    @Test
    fun shouldAddIntoCurrentPosition2() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        mMyArray.add(3.0)
        mMyArray.add(4.0)
        mMyArray.add(5.0)
        mMyArray.add(6.0)
        mMyArray.add(7.0)
        mMyArray.add(8.0)
        val iterator = mMyArray.begin()
        iterator.next()
        iterator.next()
        iterator.add(22.0)
        iterator.add(23.0)
        assertEquals(11, mMyArray.size())
    }

    @Test
    fun shouldRemoveIntoCurrentPosition2() {
        mMyArray.add(0.0)
        mMyArray.add(1.0)
        mMyArray.add(2.0)
        val iterator = mMyArray.begin()
        iterator.next()
        iterator.next()
        iterator.remove()
        assertEquals(2.0, mMyArray[1], 0.0001)
        assertEquals(2, mMyArray.size())
    }

}