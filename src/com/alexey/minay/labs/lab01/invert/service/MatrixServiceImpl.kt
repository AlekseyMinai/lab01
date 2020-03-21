package com.alexey.minay.labs.lab01.invert.service

import com.alexey.minay.labs.lab01.invert.matrix.MatrixReader
import com.alexey.minay.labs.lab01.invert.matrix.MatrixUtils
import com.alexey.minay.labs.lab01.invert.matrix.ReaderState
import com.alexey.minay.labs.lab01.invert.view.View

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