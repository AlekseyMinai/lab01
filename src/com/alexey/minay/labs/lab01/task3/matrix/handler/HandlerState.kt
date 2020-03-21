package com.alexey.minay.labs.lab01.task3.matrix.handler

sealed class HandlerState {
    class Success(val matrix: Array<DoubleArray>) : HandlerState()
    object Error : HandlerState()
}