package com.alexey.minay.labs.lab04.shape.shapes

import kotlin.math.pow

class Circle(
        private val center: Point,
        private val radius: Double,
        private val fillColor: Int,
        private val outLineColor: Int
) : SolidShape {

    override fun getFillColor() = fillColor

    override fun getArea(): Double = 3.14 * radius.pow(2)

    override fun getPerimeter(): Double = 2 * 3.14 * radius

    override fun getOutlineColor(): Int = outLineColor

    fun getCenter(): Point = center

    fun getRadius(): Double = radius

}