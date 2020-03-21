package com.alexey.minay.labs.lab01.invert.view

interface View {
    fun showResult(matrix: Array<DoubleArray>)
    fun showError(message: String)
}