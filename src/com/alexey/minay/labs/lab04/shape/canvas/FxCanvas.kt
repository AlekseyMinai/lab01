package com.alexey.minay.labs.lab04.shape.canvas

import com.alexey.minay.labs.lab04.shape.shapes.MyColor
import com.alexey.minay.labs.lab04.shape.shapes.Point
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class FxCanvas(
        private val canvas: Canvas
) : ICanvas {

    private val graphicsContext: GraphicsContext?
        get() = canvas.graphicsContext2D

    override fun drawLine(from: Point, to: Point, lineColor: MyColor) {
        graphicsContext?.stroke = lineColor.toFx()
        graphicsContext?.lineWidth = 3.0
        graphicsContext?.strokeLine(from.x, from.x, to.x, to.y)
    }

    override fun fillPolygon(points: List<Point>, fillColor: MyColor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drawCircle(center: Point, radius: Double, lineColor: MyColor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fillCircle(center: Point, radius: Double, fillColor: MyColor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun MyColor.toFx(): Color {
        return Color(red, green, blue, 1.0)
    }
}