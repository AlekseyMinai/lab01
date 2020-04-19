package com.alexey.minay.labs.lab01.invert.matrix

object MatrixUtils {

    fun invert(matrix: Array<DoubleArray>): Array<DoubleArray> {
        val matrixSize = matrix.size
        val unitMatrix = getUnitMatrixWith(matrixSize)
        for (rowIndex in 0 until matrixSize) {
            var diagonalValue = matrix[rowIndex][rowIndex]
            if (diagonalValue == 0.0) {
                getRideOfDiagonalZero(matrix, unitMatrix, rowIndex)
                diagonalValue = matrix[rowIndex][rowIndex]
            }
            getOneOnTheDiagonal(matrix, unitMatrix, rowIndex, diagonalValue)
            getZerosUnderDiagonal(matrix, unitMatrix, rowIndex)
        }
        getZerosAboveDiagonal(matrix, unitMatrix)

        return unitMatrix
    }

    private fun getUnitMatrixWith(size: Int): Array<DoubleArray> {
        val unitMatrix = mutableListOf<DoubleArray>()
        for (i in 0 until size) {
            val rowUnitMatrix = mutableListOf<Double>()
            for (k in 0 until size) {
                val value = if (k == i) 1.0 else 0.0
                rowUnitMatrix.add(value)
            }
            unitMatrix.add(rowUnitMatrix.toDoubleArray())
        }
        return unitMatrix.toTypedArray()
    }

    private fun getRideOfDiagonalZero(matrix: Array<DoubleArray>, unitMatrix: Array<DoubleArray>, rowIndex: Int) {
        var numberOfZerosInRow = 0
        for (cell in 0 until matrix.size) {
            if (matrix[rowIndex][cell] == 0.0) {
                numberOfZerosInRow++
            }
        }
        if (numberOfZerosInRow == matrix.size) {
            throw ArithmeticException("Determinant of this matrix equals zero")
        }
        var rowForSumIndex = 0
        while (matrix[rowForSumIndex][rowIndex] == 0.0) {
            rowForSumIndex++
        }
        for (cell in 0 until matrix.size) {
            matrix[rowIndex][cell] += matrix[rowForSumIndex][cell]
            unitMatrix[rowIndex][cell] += unitMatrix[rowForSumIndex][cell]
        }
    }

    private fun getOneOnTheDiagonal(matrix: Array<DoubleArray>, unitMatrix: Array<DoubleArray>, rowIndex: Int, diagonalValue: Double) {
        for (cellIndex in 0 until matrix.size) {
            matrix[rowIndex][cellIndex] /= diagonalValue
            unitMatrix[rowIndex][cellIndex] /= diagonalValue
        }
    }

    private fun getZerosUnderDiagonal(matrix: Array<DoubleArray>, unitMatrix: Array<DoubleArray>, rowIndex: Int) {
        for (setToZeroRow in rowIndex + 1 until matrix.size) {
            val setToZeroRatio = matrix[setToZeroRow][rowIndex]
            for (cell in 0 until matrix.size) {
                matrix[setToZeroRow][cell] -= matrix[rowIndex][cell] * setToZeroRatio
                unitMatrix[setToZeroRow][cell] -= unitMatrix[rowIndex][cell] * setToZeroRatio
            }
        }
    }

    private fun getZerosAboveDiagonal(matrix: Array<DoubleArray>, unitMatrix: Array<DoubleArray>) {
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

}



