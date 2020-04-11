package com.alexey.minay.labs.lab04.shape.shapes

class Rectangle(
        private val leftTop: Point,
        private val rightBottom: Point,
        private val fillColor: Int,
        private val outLineColor: Int
) : SolidShape {

    override fun getFillColor(): Int = fillColor

    override fun getArea() = getWidth() * getHeight()

    override fun getPerimeter() = getWidth() * 2 + getHeight() * 2

    override fun getOutlineColor() = outLineColor

    fun getLeftTop() = leftTop

    fun getRightBottom() = rightBottom

    fun getWidth() = rightBottom.x - leftTop.x

    fun getHeight() = leftTop.y - rightBottom.y
}