package com.alexey.minay.lab01.task3.di

import com.alexey.minay.lab01.task3.matrix.FileMatrixReader
import com.alexey.minay.lab01.task3.matrix.handler.DataHendlerImpl
import com.alexey.minay.lab01.task3.service.MatrixService
import com.alexey.minay.lab01.task3.service.MatrixServiceImpl
import com.alexey.minay.lab01.task3.view.ConsoleView

object ApplicationComponent {

    fun getService(inputData: String): MatrixService {
        val view = ConsoleView()
        val dataHandler = DataHendlerImpl()
        val matrixReader = FileMatrixReader(dataHandler, inputData)
        return MatrixServiceImpl(matrixReader, view)
    }
}