package com.alexey.minay.lab01.task3.service

import com.alexey.minay.lab01.task3.matrix.MatrixReader
import com.alexey.minay.lab01.task3.matrix.MatrixUtils
import com.alexey.minay.lab01.task3.matrix.ReaderState
import com.alexey.minay.lab01.task3.view.View

class MatrixServiceImpl(
        private val matrixReader: MatrixReader,
        private val view: View
) : MatrixService {

    override fun invert() {
        val readerState = matrixReader.read()
        when (readerState) {
            is ReaderState.Error -> view.showError("error..")
            is ReaderState.Success -> {
                val invertMatrix = MatrixUtils.invert(readerState.matrix)
                view.showResult(invertMatrix)
            }
        }
    }
}