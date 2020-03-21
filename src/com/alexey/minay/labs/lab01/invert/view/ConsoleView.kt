package com.alexey.minay.labs.lab01.invert.view

class ConsoleView : View {

    override fun showResult(matrix: Array<DoubleArray>) {
        for (row in matrix) {
            for (cell in row) {
                val value = Math.round(cell * 1000).toFloat() / 1000
                if (value > 0) print(" $value\t")
                else print("$value\t")
            }
            println()
        }
    }

    override fun showError(message: String) {
        print(message)
    }

}