package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.CanvasDrawable
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import kotlin.math.absoluteValue

class Triangle(
        private val vertex1: Point,
        private val vertex2: Point,
        private val vertex3: Point,
        private val fillColor: MyColor,
        private val outlineColor: MyColor
) : SolidShape, CanvasDrawable {

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

    override fun draw(canvas: ICanvas) {
        canvas.drawLine(vertex1, vertex2, outlineColor)
        canvas.drawLine(vertex2, vertex3, outlineColor)
        canvas.drawLine(vertex3, vertex1, outlineColor)
        canvas.fillPolygon(mutableListOf(vertex1, vertex2, vertex3), fillColor)
    }

}