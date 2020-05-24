package com.alexey.minay.labs.lab02.generator04

import org.junit.Assert.assertEquals
import org.junit.Test

class Application4KtTest {

    @Test
    fun shouldReturnCorrectQuantityPrimeNumbers() {
        val primeMembersSet = generatePrimeMembersSet(100_000_000)
        assertEquals(5761455, primeMembersSet.size)
    }

    @Test
    fun shouldReturnEmptySet() {
        val primeMembersSet = generatePrimeMembersSet(1_000_000_000)
        assertEquals(0, primeMembersSet.size)
    }

    @Test
    fun shouldReturnCorrectSet() {
        val primeMembersSet = generatePrimeMembersSet(10)
        val controlSet = setOf(2, 3, 5, 7)
        assertEquals(controlSet, primeMembersSet)
    }
}