package com.alexey.minay.labs.lab06.cubic.equation

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class ApplicationKtTest{

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowIllegalArgumentException1(){
        solve3(0.0,1.0,2.0,3.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowIllegalArgumentException2(){
        solve3(1.0,0.0,2.0,3.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowIllegalArgumentException3(){
        solve3(1.0,4.0,0.0,3.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowIllegalArgumentException4(){
        solve3(1.0,234.0,2.0,0.0)
    }

    @Test
    fun shouldReturnRoots(){
        val roots = solve3(2.0, 3.0, 5.0, 125.0)
        assertEquals(-4.3, roots.realRoots[0], 0.01)
        assertEquals("1.4 + 3.546i", roots.complexRoots[0])
        assertEquals("1.4 - 3.546i", roots.complexRoots[1])
    }

}