package com.alexey.minay.labs.lab02.generator04

import org.junit.Assert.*
import org.junit.Test

class Application4KtTest{

    @Test
    fun shouldCompleteFor10seconds(){
        val before = System.currentTimeMillis()
        main()
        val after = System.currentTimeMillis()
        assert(after - before < 10000)
    }

    @Test
    fun shouldReturnCorrectQuantityPrimeNumbers(){
        val primeMembersSet = generatePrimeMembersSet(100_000_000)
        assertEquals(5761455, primeMembersSet.size)
    }

    @Test
    fun shouldReturnEmptySet(){
        val primeMembersSet = generatePrimeMembersSet(1_000_000_000)
        assertEquals(0, primeMembersSet.size)
    }
}