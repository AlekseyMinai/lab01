package com.alexey.minay.labs.lab04.shape.shapes

class Rectangle(
        private val leftTop: Point,
        private val rightBottom: Point,
        private val fillColor: Int,
        private val outLineColor: Int
) : SolidShape {

    override fun getFillColor(): Int = fillColor

    override fun getArea() = getWidth() * getHeight()

    override fun getPerimeter(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOutlineColor(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getLeftTop() = leftTop

    fun getRightBottom() = rightBottom

    fun getWidth() = rightBottom.x - leftTop.x

    fun getHeight() = leftTop.y - rightBottom.y
}