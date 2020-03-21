package com.alexey.minay.labs.lab01.task3.view

interface View {
    fun showResult(matrix: Array<DoubleArray>)
    fun showError(message: String)
}