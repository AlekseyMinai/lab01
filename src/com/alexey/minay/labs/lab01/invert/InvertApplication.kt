package com.alexey.minay.labs.lab01.invert

import com.alexey.minay.labs.lab01.invert.matrix.FileMatrixReader
import com.alexey.minay.labs.lab01.invert.matrix.MatrixUtils
import com.alexey.minay.labs.lab01.invert.matrix.ReaderState
import java.io.File

fun main(args: Array<String>) {
    if (args.isNullOrEmpty()) {
        println("To correct start application enter: \"java -jar invert.jar <matrix file>\n\"")
        return
    }
    invert(args[0])
}

private fun invert(inputData: String) {
    val matrixReader = FileMatrixReader()
    when (val readerState = matrixReader.read(inputData)) {
        is ReaderState.Error -> println("It's no matrix in input file")
        is ReaderState.Success -> {
            try {
                val invertedMatrix = MatrixUtils.invert(readerState.matrix)
                print(invertedMatrix)
            } catch (e: ArithmeticException) {
                println(e.message)
            }
        }
    }
}

fun print(matrix: Array<DoubleArray>) {
    for (row in matrix) {
        for (cell in row) {
            val value = Math.round(cell * 1000).toFloat() / 1000
            if (value > 0) print(" $value\t")
            else print("$value\t")
        }
        println()
    }
}
