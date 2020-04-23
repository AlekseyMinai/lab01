package com.alexey.minay.labs.lab06.stringlist

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class StringListTest{

    private var mStringList = StringList()

    @Before
    fun setUp(){
        mStringList = StringList()
    }

    @Test
    fun shouldAddElement(){
        val element = "element"
        mStringList.add(element)
        assertEquals(element, mStringList.iterator().next())
    }

    @Test
    fun shouldAddTwoElements(){
        val element1 = "element1"
        val element2 = "element2"
        mStringList.add(element1)
        mStringList.add(element2)
        val iterator = mStringList.iterator()
        assertEquals(element1, iterator.next())
        assertEquals(element2, iterator.next())
    }

    @Test
    fun shouldReturnSize(){
        val element1 = "element1"
        val element2 = "element2"
        mStringList.add(element1)
        mStringList.add(element2)
        assertEquals(2, mStringList.size())
    }

    @Test
    fun shouldRemoveLast(){
        val element1 = "element1"
        val element2 = "element2"
        mStringList.add(element1)
        mStringList.add(element2)
        mStringList.remove()
        assertEquals(1, mStringList.size())
        assertEquals(element1, mStringList.iterator().next())
    }

    @Test
    fun shouldClear(){
        val element1 = "element1"
        val element2 = "element2"
        mStringList.add(element1)
        mStringList.add(element2)
        mStringList.clear()
        assertEquals(0, mStringList.size())
    }

    @Test
    fun shouldAddElementInMiddle(){
        val element1 = "element1"
        val element2 = "element2"
        val middle = "middle"
        mStringList.add(element1)
        mStringList.add(element2)
        var iterator = mStringList.iterator()
        iterator.next()
        iterator.add(middle)
        iterator = mStringList.iterator()
        iterator.next()
        assertEquals(middle, iterator.next())
    }

    @Test
    fun shouldRemoveCurrent(){
        val element1 = "element1"
        val element2 = "element2"
        mStringList.add(element1)
        mStringList.add(element2)
        var iterator = mStringList.iterator()
        iterator.remove()
        iterator = mStringList.iterator()
        assertEquals(element2, iterator.next())
    }

    @Test
    fun shouldRemoveCurrent2(){
        val element1 = "element1"
        val element2 = "element2"
        val element3 = "element3"
        mStringList.add(element1)
        mStringList.add(element2)
        mStringList.add(element3)
        var iterator = mStringList.iterator()
        iterator.next()
        iterator.remove()
        iterator = mStringList.iterator()
        iterator.next()
        assertEquals(element3, iterator.next())
    }

    @Test
    fun shouldSet(){
        val element1 = "element1"
        val element2 = "element2"
        val element3 = "element3"
        mStringList.add(element1)
        mStringList.add(element2)
        mStringList.add(element3)
        var iterator = mStringList.iterator()
        iterator.next()
        iterator.set("set")
        iterator = mStringList.iterator()
        assertEquals("set", iterator.next())
    }
}