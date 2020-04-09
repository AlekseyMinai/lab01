package com.alexey.minay.labs.lab02.template06

import org.junit.Assert.*
import org.junit.Test

class AhoCorasickTest{

    val ahoCorasick = AhoCorasick()

    @Test
    fun shouldFindAllWords(){
        val words = mutableListOf("a", "aa", "aaa")
        val text = "aaa"
        ahoCorasick.initWith(words)
        val result = ahoCorasick.searchIn(text)
        assertTrue(result.size == 3)
    }

    @Test
    fun shouldFindWordsInCorrectPlace(){
        val words = mutableListOf("a", "aa", "aaa")
        val text = "aaa"
        ahoCorasick.initWith(words)
        val result = ahoCorasick.searchIn(text)
        assertEquals("a", result[0].word)
        assertEquals("aa", result[1].word)
        assertEquals("aaa", result[2].word)
    }

    @Test
    fun shouldFindCorrectWordPlaces(){
        val words = mutableListOf("a", "aa", "aaa")
        val text = "bsdfaaa"
        ahoCorasick.initWith(words)
        val result = ahoCorasick.searchIn(text)
        assertEquals(4, result[0].place)
        assertEquals(5, result[1].place)
        assertEquals(6, result[2].place)
    }
}