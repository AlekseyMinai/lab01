package com.alexey.minay.labs.lab01.invert.matrix.handler

import java.lang.Exception

class DataHendlerImpl : DataHandler {

    override fun getSquareMatrixFrom(data: Array<String>?): HandlerState {
        if (data == null || data.size < 2) {
            return HandlerState.Error
        }
        return mapOrError(data)
    }

    private fun mapOrError(data: Array<String>): HandlerState {
        val matrix = mutableListOf<DoubleArray>()
        data.forEach { row ->
            val matrixRowString = row.split("\t")
            if (matrixRowString.size != data.size) {
                return HandlerState.Error
            }
            val matrixRow = mutableListOf<Double>()
            matrixRowString.forEach {
                try {
                    matrixRow.add(it.toDouble())
                } catch (e: Exception) {
                    return HandlerState.Error
                }
            }
            matrix.add(matrixRow.toDoubleArray())
        }
        return HandlerState.Success(matrix.toTypedArray())
    }
}