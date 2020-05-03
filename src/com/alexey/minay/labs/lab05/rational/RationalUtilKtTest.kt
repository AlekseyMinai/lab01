package com.alexey.minay.labs.lab05.rational

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class RationalUtilKtTest{

    @Test
    fun shouldReturnRationalNumberUnaryPlus(){
        val rational = Rational(-9, 2)
        val resultRational =  +rational
        assertEquals(-9, resultRational.getNumeration())
        assertEquals(2, resultRational.getDenominator())
    }

    @Test
    fun shouldReturnRationalNumberUnaryMinus(){
        val rational = Rational(-9, 2)
        val resultRational =  -rational
        assertEquals(9, resultRational.getNumeration())
        assertEquals(2, resultRational.getDenominator())
    }

    @Test
    fun shouldReturnSumOfRationalNumbers(){
        val rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        val resultRational =  rational1 + rational2
        assertEquals(-17, resultRational.getNumeration())
        assertEquals(4, resultRational.getDenominator())
    }

    @Test
    fun shouldReturnDifferenceOfRationalNumbers(){
        val rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        val resultRational =  rational1 - rational2
        assertEquals(-19, resultRational.getNumeration())
        assertEquals(4, resultRational.getDenominator())
    }

    @Test
    fun `should support '+='`(){
        var rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        rational1 += rational2
        assertEquals(-17, rational1.getNumeration())
        assertEquals(4, rational1.getDenominator())
    }

    @Test
    fun `should support '-='`(){
        var rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        rational1 -= rational2
        assertEquals(-19, rational1.getNumeration())
        assertEquals(4, rational1.getDenominator())
    }

    @Test
    fun `should support '*'`(){
        val rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        val resultRational = rational1 * rational2
        assertEquals(-9, resultRational.getNumeration())
        assertEquals(8, resultRational.getDenominator())
    }

    @Test
    fun `should support 'divide' operator`(){
        val rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        val resultRational = rational1 / rational2
        assertEquals(-18, resultRational.getNumeration())
        assertEquals(1, resultRational.getDenominator())
    }

    @Test
    fun `should support '*=' operator`(){
        var rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        rational1 *= rational2
        assertEquals(-9, rational1.getNumeration())
        assertEquals(8, rational1.getDenominator())
    }

    @Test
    fun `should divide the first rational number by the second`(){
        var rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        rational1 /= rational2
        assertEquals(-18, rational1.getNumeration())
        assertEquals(1, rational1.getDenominator())
    }

    @Test
    fun `should support '==' and '!=' operators`(){
        val rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        assert(rational1 != rational2)
        assertFalse(rational1 == rational2)
    }

    @Test
    fun `should support the ability of compare two rational number`(){
        val rational1 = Rational(-9, 2)
        val rational2 = Rational(1, 4)
        assert(rational1 < rational2)
        assertFalse(rational1 >= rational2)
    }

    @Test
    fun `should return compound fraction`(){
        val rational1 = Rational(-9, 2)
        val compoundFractionRational = rational1.toCompoundFraction()
        assertEquals(-4, compoundFractionRational.first)
        assertEquals(1, compoundFractionRational.second.getNumeration())
        assertEquals(2, compoundFractionRational.second.getDenominator())
    }
}