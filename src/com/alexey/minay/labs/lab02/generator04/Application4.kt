package com.alexey.minay.labs.lab02.generator04

import java.lang.StrictMath.sqrt

fun main() {
    val before = System.currentTimeMillis()
    val primeMembersSet = generatePrimeMembersSet2(100_000_000)
    val after = System.currentTimeMillis()
    println(after - before)
    print(primeMembersSet.size)
}

fun generatePrimeMembersSet2(upperBound: Int): Set<Int> {
    if (upperBound > 100_000_000) {
        print("Превышен допустимый порог")
        return emptySet()
    }
    val list = MutableList(upperBound + 1) { true }

    val before = System.currentTimeMillis()
    val bef = sqrt(upperBound.toDouble()).toInt()
    for (i in 0 until bef) {
        if (i < 2) {
            list[i] = false
        }

        if (list[i]) {
            for (j in i * i..upperBound step i) {
                list[j] = false
            }
        }
    }

    val after = System.currentTimeMillis()
    println(after - before)

    val set = mutableSetOf<Int>()
    list.forEachIndexed { index, isPrime ->
        if (isPrime) set.add(index)
    }

    return set
}

