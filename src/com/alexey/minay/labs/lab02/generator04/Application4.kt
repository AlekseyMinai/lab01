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

//fun generatePrimeMembersSet2(upperBound: Int): Set<Int> {
//    if (upperBound > 100_000_000) {
//        print("Превышен допустимый порог")
//        return emptySet()
//    }
//    val list = MutableList(upperBound + 1) { true }
//
//    val before = System.currentTimeMillis()
//    val bef = sqrt(upperBound.toDouble()).toInt()
//    for (i in 0 until bef) {
//        if (i < 2) {
//            list[i] = false
//        }
//
//        if (list[i]) {
//            for (j in i * i..upperBound step i) {
//                list[j] = false
//            }
//        }
//    }
//
//    val after = System.currentTimeMillis()
//    println(after - before)
//
//    val set = mutableSetOf<Int>()
//    list.forEachIndexed { index, isPrime ->
//        if (isPrime) set.add(index)
//    }
//
//    return set
//}


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









/*fun generatePrimeMembersSet2(upperBound: Int): Set<Int> {
    val cache = 30000
    val m = sqrt(upperBound.toDouble()).toInt() + 1

    val primes = MutableList(m) { 0 }
    val segment = MutableList(cache) { true }

    for (i in m - 1 until upperBound step cache) {
        for (j in 0 until m) {
            val h = i % primes[i]
            val jj = if (h > 0) primes[i] - h else 0
            for (k in jj until cache step primes[i]){
                segment[j] = false
            }
        }



    }

}*/
