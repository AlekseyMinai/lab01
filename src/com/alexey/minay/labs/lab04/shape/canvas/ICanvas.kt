package com.alexey.minay.labs.lab04.shape.canvas

import com.alexey.minay.labs.lab04.shape.shapes.Point

interface ICanvas {

    fun drawLine(from: Point, to: Point, lineColor: Int)
    fun fillPolygon(points: List<Point>, fillColor: Int)
    fun drawCircle(center: Point, radius: Double, lineColor: Int)
    fun fillCircle(center: Point, radius: Double, fillColor: Int)

}