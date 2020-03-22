package com.alexey.minay.labs.lab02.generator04

import java.lang.StrictMath.sqrt
import java.util.*

fun main() {
    val before = System.currentTimeMillis()
    val primeMembersSet = generatePrimeMembersSet3(100_000_000)
    val after = System.currentTimeMillis()
    println(after - before)
    print(primeMembersSet.size)
}

fun generatePrimeMembersSet3(upperBound: Int): Set<Int> {
    if (upperBound > 100_000_000) {
        print("Превышен допустимый порог")
        return emptySet()
    }
    val list = BitSet(upperBound)
    val bef = sqrt(upperBound.toDouble()).toInt()
    for (i in 0 until bef) {
        if (i < 2) {
            list.set(i)
        }

        if (!list[i]) {
            for (j in i * i..upperBound step i) {
                list.set(j)
            }
        }
    }

   val set = mutableSetOf<Int>()

    for(i in 0 until upperBound){
        if (!list[i]){
            set.add(i)
        }
    }
    return set
}

