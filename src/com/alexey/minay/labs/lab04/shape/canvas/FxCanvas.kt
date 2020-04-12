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
        graphicsContext?.strokeLine(from.x, from.y, to.x, to.y)
    }

    override fun fillPolygon(points: List<Point>, fillColor: MyColor) {
        graphicsContext?.fill = fillColor.toFx()
        val xPoints = mutableListOf<Double>()
        val yPoints = mutableListOf<Double>()
        points.forEach {
            xPoints.add(it.x)
            yPoints.add(it.y)
        }
        graphicsContext?.fillPolygon(xPoints.toDoubleArray(), yPoints.toDoubleArray(), points.size)
    }

    override fun drawCircle(center: Point, radius: Double, lineColor: MyColor) {
        graphicsContext?.stroke = lineColor.toFx()
        graphicsContext?.strokeOval(center.x - radius, center.y - radius, radius * 2, radius * 2)
    }

    override fun fillCircle(center: Point, radius: Double, fillColor: MyColor) {
        graphicsContext?.fill = fillColor.toFx()
        graphicsContext?.fillOval(center.x - radius, center.y - radius, radius * 2, radius * 2)
    }

    override fun clearAll() {
        graphicsContext?.clearRect(0.0, 0.0, 1000.0, 800.0)
    }

    private fun MyColor.toFx(): Color {
        return Color(red, green, blue, 1.0)
    }
}