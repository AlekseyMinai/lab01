package com.alexey.minay.lab01.task3

class InvertApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 8, 4), intArrayOf(3, 4, 5))
            printMatrix(matrix)
            println()
            print(findDeterminantOf3x3(matrix))
        }

        private fun printMatrix(matrix: Array<IntArray>){
            for (row in matrix){
                for (cell in row){
                    print("$cell ")
                }
                println()
            }
        }
    }
}