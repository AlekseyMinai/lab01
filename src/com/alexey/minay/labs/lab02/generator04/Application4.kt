package com.alexey.minay.labs.lab02.generator04

import java.lang.NumberFormatException
import java.lang.StrictMath.sqrt
import java.util.*

fun main() {
    println("Введите значение upperBound")
    val userInput = readLine()
    val isNumber = userInput?.matches("""[0-9]+""".toRegex()) ?: return
    if (!isNumber) {
        println("$userInput не является числом")
        return
    }
    try {
        val primeMembersSet = generatePrimeMembersSet(userInput.toInt())
        print(primeMembersSet.size)
    } catch (e: NumberFormatException){
        print("$e. Слишком большое число")
    }

}

fun generatePrimeMembersSet(upperBound: Int): Set<Int> {
    if (upperBound > 100_000_000) {
        print("Превышен допустимый порог")
        return emptySet()
    }
    val numBitSet = BitSet(upperBound)
    markPrimeNumberIn(numBitSet, upperBound)
    return generatePrimeMembersSet(numBitSet, upperBound)
}

private fun markPrimeNumberIn(numbBitSet: BitSet, upperBound: Int) {
    val before = sqrt(upperBound.toDouble()).toInt()
    for (i in 0..before) {
        if (i < 2) {
            numbBitSet.set(i)
        }

        if (!numbBitSet[i]) {
            for (j in i * i..upperBound step i) {
                numbBitSet.set(j)
            }
        }
    }
}

private fun generatePrimeMembersSet(numBitSet: BitSet, upperBound: Int): Set<Int> {
    val primeMembersSet = mutableSetOf<Int>()
    for (i in 0 until upperBound) {
        if (!numBitSet[i]) {
            primeMembersSet.add(i)
        }
    }
    return primeMembersSet
}



