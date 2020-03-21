package com.alexey.minay.labs.lab01.task3.matrix

sealed class ReaderState {
    class Success(val matrix: Array<DoubleArray>) : ReaderState()
    object Error : ReaderState()
}