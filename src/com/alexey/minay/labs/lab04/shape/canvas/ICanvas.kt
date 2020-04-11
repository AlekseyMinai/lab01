package com.alexey.minay.labs.lab04.shape.canvas

import com.alexey.minay.labs.lab04.shape.shapes.MyColor
import com.alexey.minay.labs.lab04.shape.shapes.Point

interface ICanvas {

    fun drawLine(from: Point, to: Point, lineColor: MyColor)
    fun fillPolygon(points: List<Point>, fillColor: MyColor)
    fun drawCircle(center: Point, radius: Double, lineColor: MyColor)
    fun fillCircle(center: Point, radius: Double, fillColor: MyColor)

}