package com.alexey.minay.labs.lab03.calculator

class Function(
        val firstKeyVariable: String,
        val secondKeyVariable: String,
        val function: (firstArg: Double, secondArg: Double) -> Double,
        var lazyResult: Double? = null
)