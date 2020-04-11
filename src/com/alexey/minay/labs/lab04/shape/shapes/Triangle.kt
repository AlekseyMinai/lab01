package com.alexey.minay.labs.lab04.shape.shapes

import kotlin.math.absoluteValue

class Triangle(
        private val vertex1: Point,
        private val vertex2: Point,
        private val vertex3: Point,
        private val fillColor: Int,
        private val outlineColor: Int
) : SolidShape {

    override fun getFillColor() = fillColor

    override fun getArea() = ((vertex1.x - vertex3.x) * (vertex2.y - vertex3.y) -
            (vertex1.y - vertex3.y) * (vertex2.x - vertex3.x)).absoluteValue / 2.0

    override fun getPerimeter() = LineSegment(outlineColor, vertex1, vertex2).getLength() +
            LineSegment(outlineColor, vertex1, vertex3).getLength() +
            LineSegment(outlineColor, vertex2, vertex3).getLength()

    override fun getOutlineColor() = outlineColor

    fun getVertex1() = vertex1

    fun getVertex2() = vertex2

    fun getVertex3() = vertex3

}