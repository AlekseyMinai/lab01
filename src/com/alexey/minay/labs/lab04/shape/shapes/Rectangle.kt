package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.canvas.CanvasDrawable

class Rectangle(
        private val leftTop: Point,
        private val rightBottom: Point,
        private val fillColor: MyColor,
        private val outLineColor: MyColor
) : SolidShape, CanvasDrawable {

    override fun getFillColor() = fillColor

    override fun getArea() = getWidth() * getHeight()

    override fun getPerimeter() = getWidth() * 2 + getHeight() * 2

    override fun getOutlineColor() = outLineColor

    fun getLeftTop() = leftTop

    fun getRightBottom() = rightBottom

    fun getWidth() = rightBottom.x - leftTop.x

    fun getHeight() = leftTop.y - rightBottom.y

    override fun draw(canvas: ICanvas) {

    }
}