package com.alexey.minay.labs.lab01.invert

import com.alexey.minay.labs.lab01.invert.matrix.FileMatrixReader
import com.alexey.minay.labs.lab01.invert.matrix.MatrixUtils
import com.alexey.minay.labs.lab01.invert.matrix.ReaderState
import com.alexey.minay.labs.lab01.invert.matrix.handler.DataHendlerImpl
import com.alexey.minay.labs.lab01.invert.view.ConsoleView

class InvertApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isNullOrEmpty()) {
                print("Отсутствует аргумент")
                return
            }
            InvertApplication().invert(args[0])
        }
    }

    private fun invert(inputData: String) {
        val view = ConsoleView()
        val dataHandler = DataHendlerImpl()
        val matrixReader = FileMatrixReader(dataHandler, inputData)
        when (val readerState = matrixReader.read()) {
            is ReaderState.Error -> view.showError("error..")
            is ReaderState.Success -> {
                val invertMatrix = MatrixUtils.invert(readerState.matrix)
                view.showResult(invertMatrix)
            }
        }
    }
}