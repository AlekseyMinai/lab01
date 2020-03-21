package com.alexey.minay.labs.lab01.invert.matrix.handler

sealed class HandlerState {
    class Success(val matrix: Array<DoubleArray>) : HandlerState()
    object Error : HandlerState()
}