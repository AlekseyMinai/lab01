package com.alexey.minay.labs.lab01.invert.matrix

import java.io.File

class FileMatrixReader {

    fun read(url: String): ReaderState {
        val file = File(url)
        if (!file.exists()) {
            return ReaderState.Error
        }
        val bufferedReader = file.bufferedReader()
        val iterator = bufferedReader.lineSequence().iterator()
        val readRows = mutableListOf<String>()
        iterator.forEach {
            readRows.add(it)
        }
        return getSquareMatrixFrom(readRows.toTypedArray())
    }

    private fun getSquareMatrixFrom(matrixRows: Array<String>?): ReaderState {
        if (matrixRows == null || matrixRows.size < 2) {
            return ReaderState.Error
        }
        val matrix = mutableListOf<DoubleArray>()
        matrixRows.forEach { row ->
            val matrixCells = row.split("\t")
            if (matrixCells.size != matrixRows.size) {
                return ReaderState.Error
            }
            val matrixRow = mutableListOf<Double>()
            matrixCells.forEach {
                try {
                    matrixRow.add(it.toDouble())
                } catch (e: Exception) {
                    return ReaderState.Error
                }
            }
            matrix.add(matrixRow.toDoubleArray())
        }
        return ReaderState.Success(matrix.toTypedArray())
    }
}