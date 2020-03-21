package com.alexey.minay.labs.lab01.invert.di

import com.alexey.minay.labs.lab01.invert.matrix.FileMatrixReader
import com.alexey.minay.labs.lab01.invert.matrix.handler.DataHendlerImpl
import com.alexey.minay.labs.lab01.invert.service.MatrixService
import com.alexey.minay.labs.lab01.invert.service.MatrixServiceImpl
import com.alexey.minay.labs.lab01.invert.view.ConsoleView

object ApplicationComponent {

    fun getService(inputData: String): MatrixService {
        val view = ConsoleView()
        val dataHandler = DataHendlerImpl()
        val matrixReader = FileMatrixReader(dataHandler, inputData)
        return MatrixServiceImpl(matrixReader, view)
    }
}