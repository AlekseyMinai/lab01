package com.alexey.minay.labs.lab03.calculator

sealed class ParserState {
    class Success(val function: Function) : ParserState()
    object IncorrectFunction : ParserState()
}