package com.alexey.minay.lab01.task3

class InvertApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


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