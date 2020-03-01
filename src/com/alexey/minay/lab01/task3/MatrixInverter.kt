package com.alexey.minay.lab01.task3

//fun Array<IntArray>.invert(): Array<IntArray> {
//
//}

fun findDeterminant(matrix: Array<IntArray>): Int {
    if(matrix.size == 1){
        return matrix[0][0]
    }
    var determinant = 0
    var changingSing = 1
    matrix.forEachIndexed { index, row ->
        val minorMatrix = findMinorOf(matrix, index, 0)
        val determinant1 = findDeterminant(minorMatrix)
        determinant += row[0] * determinant1 * changingSing
        changingSing *= -1
    }
    return determinant
}

fun findMinorOf(matrix: Array<IntArray>, rowPosition: Int, columnPosition: Int): Array<IntArray> {
    val minorDeterminant = arrayListOf<IntArray>()
    matrix.forEachIndexed { rowIndex, row ->
        if (rowIndex != rowPosition) {
            val rowArray = arrayListOf<Int>()
            row.forEachIndexed { index, column ->
                if (index != columnPosition) {
                    rowArray.add(column)
                }
            }
            minorDeterminant.add(rowArray.toIntArray())
        }
    }
    return minorDeterminant.toTypedArray()
}



