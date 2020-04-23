package com.alexey.minay.labs.lab06.cubic.equation

import kotlin.math.*

class CubicEquation(
        private val a0: Double,
        private val a1: Double,
        private val a2: Double,
        private val a3: Double
) {
    private val b1: Double
        get() = a1 / a0
    private val b2: Double
        get() = a2 / a0
    private val b3: Double
        get() = a3 / a0

    fun getRoots(): Roots {
        val q = (b1.pow(2) - 3 * b2) / 9
        val r = (2 * b1.pow(3) - 9 * b1 * b2 + 27 * b3) / 54
        val s = q.pow(3) - r.pow(2)
        if (s > 0) {
            val d = 1.0 / 3.0 * acos(r / sqrt((q).pow(3)))
            val x1 = -2.0 * sqrt(q) * cos(d) - b1 / 3.0
            val x2 = -2.0 * sqrt(q) * cos(d + Math.PI * 2.0 / 3.0) - b1 / 3.0
            val x3 = -2.0 * sqrt(q) * cos(d - Math.PI * 2.0 / 3.0) - b1 / 3.0
            return Roots(realRoots = mutableListOf(x1, x2, x3))
        } else {
            when {
                q > 0 -> {
                    val d = acosh(r.absoluteValue / sqrt((q).pow(3))) / 3
                    val x1 = -2 * sign(r) * sqrt(q) * cosh(d) - b1 / 3
                    val x2 = "${(sign(r) * sqrt(q) * cosh(d) - b1 / 3).roundTo(3)} + ${(sqrt(3.0) * sqrt(q) * sinh(d)).roundTo(3)}i"
                    val x3 = "${(sign(r) * sqrt(q) * cosh(d) - b1 / 3).roundTo(3)} - ${(sqrt(3.0) * sqrt(q) * sinh(d)).roundTo(3)}i"
                    return Roots(
                            realRoots = mutableListOf(x1),
                            complexRoots = mutableListOf(x2, x3)
                    )
                }
                q < 0 -> {
                    val d = asinh(r.absoluteValue / sqrt((q.absoluteValue).pow(3))) / 3
                    val x1 = -2 * sign(r) * sqrt(q.absoluteValue) * sinh(d) - b1 / 3
                    val x2 = "${(sign(r) * sqrt(q.absoluteValue) * sinh(d) - b1 / 3).roundTo(3)} + ${(sqrt(3.0) * sqrt(q.absoluteValue) * cosh(d)).roundTo(3)}i"
                    val x3 = "${(sign(r) * sqrt(q.absoluteValue) * sinh(d) - b1 / 3).roundTo(3)} - ${(sqrt(3.0) * sqrt(q.absoluteValue) * cosh(d)).roundTo(3)}i"
                    return Roots(
                            realRoots = mutableListOf(x1),
                            complexRoots = mutableListOf(x2, x3)
                    )
                }
                else -> {
                    val x1 = -(b3 - b1.pow(3) / 27).pow(1 / 3) - b1 / 3
                    val x2 = "${(-(b1 + x1) / 2).roundTo(3)} + ${(sqrt(((b1 - 3 * x1) * (b1 + x1) - 4 * b2).absoluteValue)).roundTo(3)}i"
                    val x3 = "${(-(b1 + x1) / 2).roundTo(3)} - ${(sqrt(((b1 - 3 * x1) * (b1 + x1) - 4 * b2).absoluteValue)).roundTo(3)}i"
                    return Roots(
                            realRoots = mutableListOf(x1),
                            complexRoots = mutableListOf(x2, x3)
                    )
                }
            }
        }
    }

    class Roots(
            val realRoots: List<Double> = mutableListOf(),
            val complexRoots: List<String> = mutableListOf()
    ) {
        val numRealRoots = realRoots.size
        val numComplexRoots = complexRoots.size

        override fun toString(): String {
            val builder = StringBuilder()
            realRoots.forEachIndexed { index, root ->
                builder.append("x${index + 1} = ${root.roundTo(3)}\n")
            }
            complexRoots.forEachIndexed { index, root ->
                builder.append("x${index + 1 + numRealRoots} = $root\n")
            }
            return builder.toString()
        }

    }
}