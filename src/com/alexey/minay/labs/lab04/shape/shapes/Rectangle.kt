package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.CanvasDrawable
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas

class Rectangle(
        private val leftTop: Point,
        private val rightBottom: Point,
        private val fillColor: MyColor,
        private val outlineColor: MyColor
) : SolidShape, CanvasDrawable {

    private val rightTop: Point by lazy { Point(rightBottom.x, leftTop.y) }
    private val leftBottom: Point by lazy { Point(leftTop.x, rightBottom.y) }

    override fun getFillColor() = fillColor

    override fun getArea() = getWidth() * getHeight()

    override fun getPerimeter() = getWidth() * 2 + getHeight() * 2

    override fun getOutlineColor() = outlineColor

    fun getLeftTop() = leftTop

    fun getRightBottom() = rightBottom

    fun getWidth() = rightBottom.x - leftTop.x

    fun getHeight() = leftTop.y - rightBottom.y

    override fun draw(canvas: ICanvas) {
        canvas.drawLine(rightTop, leftTop, outlineColor)
        canvas.drawLine(rightTop, rightBottom, outlineColor)
        canvas.drawLine(rightBottom, leftBottom, outlineColor)
        canvas.drawLine(leftBottom, leftTop, outlineColor)
        canvas.fillPolygon(mutableListOf(rightTop, rightBottom, leftBottom, leftTop), fillColor)
    }
}