package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.CanvasDrawable
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import kotlin.math.pow

class LineSegment(
        private val outlineColor: MyColor,
        private val start: Point,
        private val end: Point
) : Shape, CanvasDrawable {

    override fun getArea() = 0.0

    override fun getPerimeter() = 0.0

    override fun getOutlineColor() = outlineColor

    override fun toString(): String {
        return "Line Segment with start = $start and end = $end"
    }

    fun getStartPoint() = start

    fun getEndPoint() = end

    fun getLength() = ((end.x - start.x).pow(2) + (end.y - start.y).pow(2)).pow(0.5)

    override fun draw(canvas: ICanvas) {
        canvas.drawLine(start, end, outlineColor)
    }
}