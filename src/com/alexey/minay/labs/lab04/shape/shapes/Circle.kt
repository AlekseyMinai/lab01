package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.CanvasDrawable
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import kotlin.math.pow

class Circle(
        private val center: Point,
        private val radius: Double,
        private val fillColor: MyColor,
        private val outlineColor: MyColor
) : SolidShape, CanvasDrawable {

    override fun getFillColor() = fillColor

    override fun getArea(): Double = PI * radius.pow(2)

    override fun getPerimeter(): Double = 2 * PI * radius

    override fun getOutlineColor() = outlineColor

    fun getCenter(): Point = center

    fun getRadius(): Double = radius

    override fun draw(canvas: ICanvas) {
        canvas.drawCircle(center, radius, outlineColor)
        canvas.fillCircle(center, radius, fillColor)
    }

    override fun toString(): String {
        return "Circle with center $center, " +
                "radius = $radius, fillColor = $fillColor, outlineColor = $outlineColor"
    }

    companion object {
        const val PI = 3.14
    }

}