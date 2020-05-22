package com.alexey.minay.labs.lab06.cubic.equation

import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    val coefficients = mutableListOf<Double>()
    var input: String?
    println("To exit input (ctrl + d)...")
    do {
        if (coefficients.isEmpty())
            println("Input four coefficients: ")
        input = readLine()
        val coefficient = input?.toDoubleOrNull()
        coefficient?.let { coefficients.add(it) }
        if (coefficients.size == 4) {
            try {
                val roots = solve3(
                        a = coefficients[0],
                        b = coefficients[1],
                        c = coefficients[2],
                        d = coefficients[3]
                )
                println("Roots of equation: ")
                println(roots)
                coefficients.clear()
            } catch (ias: IllegalArgumentException) {
                println(ias)
            }
        }
    } while (input != null)

}

fun String?.toDoubleOrNull(): Double? {
    return try {
        this?.toDouble()
    } catch (e: NumberFormatException) {
        println(e)
        null
    }
}

fun solve3(a: Double, b: Double, c: Double, d: Double): CubicEquation.Roots {
    if (a == 0.0) {
        throw IllegalArgumentException("The first argument cannot be equals 0")
    }
    return CubicEquation(a, b, c, d).getRoots()
}

fun Double.roundTo(char: Int) = (this * 10.0.pow(char)).roundToInt().toDouble() / 10.0.pow(char)
