package com.alexey.minay.labs.lab04.shape.shapes

import kotlin.math.pow

class Circle(
        private val center: Point,
        private val radius: Double,
        private val fillColor: Int,
        private val outlineColor: Int
) : SolidShape {

    override fun getFillColor() = fillColor

    override fun getArea(): Double = PI * radius.pow(2)

    override fun getPerimeter(): Double = 2 * PI * radius

    override fun getOutlineColor(): Int = outlineColor

    fun getCenter(): Point = center

    fun getRadius(): Double = radius

    override fun toString(): String {
        return "Circle with center $center, " +
                "radius = $radius, fillColor = $fillColor, outlineColor = $outlineColor"
    }

    companion object {
        const val PI = 3.14
    }

}