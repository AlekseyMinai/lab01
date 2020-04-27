package com.alexey.minay.labs.lab02.vector01.var1

import kotlin.math.roundToInt

//var 1
fun main() {
    val doubleList = readInput()
    val sortedListOfDouble = doubleList.sorted()
    val listOfPositiveDoubles = sortedListOfDouble.filter { it > 0 }
    val averageOfListOfPositiveDouble = when {
        listOfPositiveDoubles.isNotEmpty() -> listOfPositiveDoubles.sum() / listOfPositiveDoubles.size
        else -> 0.0
    }
    sortedListOfDouble
            .map { it + averageOfListOfPositiveDouble }
            .forEach { print("$it ") }
}

fun readInput(): List<Double> {
    print("Введите числа с плавающей точкой, разделенные пробелами:\n")
    return readLine().toString().toListOfDouble()
}

fun String.toListOfDouble(): List<Double> {
    return this.split(" ").mapNotNull {
        try {
            it.toDouble()
        } catch (e: NumberFormatException) {
            print("\"$it\" - не число \n")
            null
        }
    }
}

fun Double.roundTo3Char() = (this * 1000).roundToInt().toDouble() / 1000
