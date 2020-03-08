package com.alexey.minay.lab01.task3

import java.util.*

fun main(args: Array<String>) {
    val matrix = getRandomMatrixWith(1300)
    printMatrix(matrix)
    println()
    printMatrix(invert(matrix))
}

fun printMatrix(matrix: Array<FloatArray>) {
    matrix.forEach { row ->
        row.forEach { cell ->
            print("$cell ")
        }
        println()
    }
}

fun invert(matrix: Array<FloatArray>): Array<FloatArray> {
    val matrixSize = matrix.size
    val unitMatrix = getUnitMatrixWith(matrixSize)
    for (rowIndex in 0 until matrixSize) {
        var diagonalValue = matrix[rowIndex][rowIndex]
        if (diagonalValue == 0f) {
            getRideOfDiagonalZero(matrix, unitMatrix, rowIndex)
            diagonalValue = matrix[rowIndex][rowIndex]
        }
        getOneOnTheDiagonal(matrix, unitMatrix, rowIndex, diagonalValue)
        getZeroUnderDiagonal(matrix, unitMatrix, rowIndex)
    }
    getZeroAboveDiagonal(matrix, unitMatrix)
    return unitMatrix
}


fun getZeroUnderDiagonal(matrix: Array<FloatArray>, unitMatrix: Array<FloatArray>, rowIndex: Int) {
    for (setToZeroRow in rowIndex + 1 until matrix.size) {
        val setToZeroRatio = matrix[setToZeroRow][rowIndex]
        for (cell in 0 until matrix.size) {
            matrix[setToZeroRow][cell] -= matrix[rowIndex][cell] * setToZeroRatio
            unitMatrix[setToZeroRow][cell] -= unitMatrix[rowIndex][cell] * setToZeroRatio
        }
    }
}

fun getZeroAboveDiagonal(matrix: Array<FloatArray>, unitMatrix: Array<FloatArray>) {
    for (setToZeroColumn in matrix.size - 1 downTo 1) {
        for (setToZeroRow in setToZeroColumn - 1 downTo 0) {
            val setToZeroRatio = matrix[setToZeroRow][setToZeroColumn]
            for (cell in 0 until matrix.size) {
                matrix[setToZeroRow][cell] -= matrix[setToZeroColumn][cell] * setToZeroRatio
                unitMatrix[setToZeroRow][cell] -= unitMatrix[setToZeroColumn][cell] * setToZeroRatio
            }
        }
    }
}

fun getOneOnTheDiagonal(matrix: Array<FloatArray>, unitMatrix: Array<FloatArray>, rowIndex: Int, diagonalValue: Float) {
    for (cellIndex in 0 until matrix.size) {
        matrix[rowIndex][cellIndex] /= diagonalValue
        unitMatrix[rowIndex][cellIndex] /= diagonalValue
    }
}

fun getRideOfDiagonalZero(matrix: Array<FloatArray>, unitMatrix: Array<FloatArray>, rowIndex: Int) {
    var rowForSumIndex = 0
    while (matrix[rowForSumIndex][rowIndex] == 0f) {
        rowForSumIndex++
    }
    for (cell in 0 until matrix.size) {
        matrix[rowIndex][cell] += matrix[rowForSumIndex][cell]
        unitMatrix[rowIndex][cell] += unitMatrix[rowForSumIndex][cell]
    }
}

fun getUnitMatrixWith(size: Int): Array<FloatArray> {
    val unitMatrix = mutableListOf<FloatArray>()
    for (i in 0 until size) {
        val rowUnitMatrix = mutableListOf<Float>()
        for (k in 0 until size) {
            val value = if (k == i) 1f else 0f
            rowUnitMatrix.add(value)
        }
        unitMatrix.add(rowUnitMatrix.toFloatArray())
    }
    return unitMatrix.toTypedArray()
}

fun getRandomMatrixWith(size: Int): Array<FloatArray> {
    val randomMatrix = mutableListOf<FloatArray>()
    for (i in 0 until size) {
        val rowUnitMatrix = mutableListOf<Float>()
        for (k in 0 until size) {
            val value = Random().nextInt(9)
            rowUnitMatrix.add(value.toFloat())
        }
        randomMatrix.add(rowUnitMatrix.toFloatArray())
    }
    return randomMatrix.toTypedArray()
}