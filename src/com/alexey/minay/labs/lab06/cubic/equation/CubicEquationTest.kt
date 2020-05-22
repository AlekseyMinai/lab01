package com.alexey.minay.labs.lab06.cubic.equation

import org.junit.Assert.assertEquals
import org.junit.Test

class CubicEquationTest {

    @Test
    fun shouldReturnRoots() {
        val equation = CubicEquation(2.0, 3.0, 5.0, 125.0)
        val roots = equation.getRoots()
        assertEquals(-4.3, roots.realRoots[0], 0.01)
        assertEquals("1.4 + 3.546i", roots.complexRoots[0])
        assertEquals("1.4 - 3.546i", roots.complexRoots[1])
    }

    @Test
    fun shouldReturnAllRealRoots() {
        val equation = CubicEquation(2.0, 1000.0, 5.0, -3.0)
        val roots = equation.getRoots()
        assertEquals(-499.99, roots.realRoots[0], 0.01)
        assertEquals(0.05, roots.realRoots[1], 0.01)
        assertEquals(-0.06, roots.realRoots[2], 0.01)
    }


    @Test
    fun shouldReturnTwoRealRoots() {
        val equation = CubicEquation(8.0, 12.0, 6.0, 1.0)
        val roots = equation.getRoots()
        assertEquals(-0.5, roots.realRoots[0], 0.01)
        assertEquals(-0.5, roots.realRoots[1], 0.01)
    }

    @Test
    fun shouldReturnRoots2() {
        val equation = CubicEquation(2000.0, -3.0, 55.0, -1.0)
        val roots = equation.getRoots()
        assertEquals(0.017, roots.realRoots[0], 0.001)
        assertEquals("-0.008 + 0.167i", roots.complexRoots[0])
        assertEquals("-0.008 - 0.167i", roots.complexRoots[1])
    }
}