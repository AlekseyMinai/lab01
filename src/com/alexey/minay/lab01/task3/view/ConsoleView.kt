package com.alexey.minay.lab01.task3.view

class ConsoleView : View {

    override fun showResult(matrix: Array<DoubleArray>) {
        for (row in matrix) {
            for (cell in row) {
                val value = Math.round(cell * 1000).toFloat() / 1000
                print("$value ")
            }
            println()
        }
    }

    override fun showError(message: String) {
        print(message)
    }

}