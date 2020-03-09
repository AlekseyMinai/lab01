package com.alexey.minay.lab01.task3.matrix.handler

sealed class HandlerState {
    class Success(val matrix: Array<DoubleArray>) : HandlerState()
    object Error : HandlerState()
}