package com.alexey.minay.lab01.task3

//fun Array<IntArray>.invert(): Array<IntArray> {
//
//}

fun findDeterminantOf3x3(matrix: Array<IntArray>): Int {

    return matrix[0][0] * matrix[1][1] * matrix[2][2] +
            matrix[2][0] * matrix[0][1] * matrix[1][2] +
            matrix[1][0] * matrix[2][1] * matrix[0][2] -
            matrix[2][0] * matrix[1][1] * matrix[0][2] -
            matrix[0][0] * matrix[2][1] * matrix[1][2] -
            matrix[1][0] * matrix[0][1] * matrix[2][2]
}

