package com.alexey.minay.labs.lab04.shape.canvas

import com.alexey.minay.labs.lab04.shape.shapes.Point
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext

class FxCanvas(
    private val canvas: Canvas
) : ICanvas {

    private val graphicsContext: GraphicsContext?
        get() = canvas.graphicsContext2D

    override fun drawLine(from: Point, to: Point, lineColor: Int) {
        graphicsContext?.strokeLine(40.0, 10.0, 10.0, 40.0)
    }

    override fun fillPolygon(points: List<Point>, fillColor: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drawCircle(center: Point, radius: Double, lineColor: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fillCircle(center: Point, radius: Double, fillColor: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}