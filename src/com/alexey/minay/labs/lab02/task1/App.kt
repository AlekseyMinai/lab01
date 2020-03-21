package com.alexey.minay.labs.lab02.task1

import java.util.*
import kotlin.math.roundToInt

//var 1
fun main(args: Array<String>) {
    val doubleList = readIn()
    doubleList
            .addAverageToPositiveValue()
            .sorted()
            .forEach { print("$it ") }
}

private fun readIn(): List<Double> {
    val scanner = Scanner(System.`in`)
    println("Введите числа с плавающей точкой, разделенные пробелами:")
    val input = scanner.nextLine()
    return input.toDoubleList()
}

private fun String.toDoubleList(): List<Double> {
    val splittedString = this.split(" ")
    val floatList = mutableListOf<Double>()
    splittedString.forEach {
        try {
            floatList.add(it.toDouble())
        } catch (e: NumberFormatException) {
            print("\"$it\" - не число")
        }
    }
    return floatList
}

private fun List<Double>.addAverageToPositiveValue() =
        map {
            if (it > 0) {
                return@map it + average().roundTo3Char()
            } else {
                it
            }
        }

private fun Double.roundTo3Char() = (this * 1000).roundToInt().toDouble() / 1000



