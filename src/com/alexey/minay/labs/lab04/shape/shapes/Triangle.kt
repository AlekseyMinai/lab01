package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.CanvasDrawable
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import kotlin.math.absoluteValue
import kotlin.math.pow

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

    override fun getPerimeter() = getSideLength(vertex1, vertex2) +
            getSideLength(vertex1, vertex3) +
            getSideLength(vertex2, vertex3)

    private fun getSideLength(start: Point, end: Point) =
            ((end.x - start.x).pow(2) + (end.y - start.y).pow(2)).pow(0.5)

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

    override fun toString(): String {
        return "Triangle with vertex1 = $vertex1, vertex2 = $vertex2, " +
                "vertex3 = $vertex3, fillColor = $fillColor, outlineColor = $outlineColor"
    }

}