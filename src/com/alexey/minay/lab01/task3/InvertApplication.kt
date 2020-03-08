package com.alexey.minay.lab01.task3

import kotlin.random.Random

class InvertApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix = arrayListOf<IntArray>()
            for (row in 1..12) {
                val ar = arrayListOf<Int>()
                for (cell in 1..12) {
                    ar.add(Random.nextInt(10))
                }
                matrix.add(ar.toIntArray())
            }
            printMatrix(matrix.toTypedArray())
            println()
            val before = System.currentTimeMillis()
            val d = findDeterminant(matrix.toTypedArray())
            val after = System.currentTimeMillis()
            print(d)
            println()
            print(after - before)

        }

        private fun printMatrix(matrix: Array<IntArray>) {
            for (row in matrix) {
                for (cell in row) {
                    print("$cell ")
                }
                println()
            }
        }
    }
}