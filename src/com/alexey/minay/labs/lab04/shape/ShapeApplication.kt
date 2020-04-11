package com.alexey.minay.labs.lab04.shape

import com.alexey.minay.labs.lab04.shape.shapes.Point
import com.alexey.minay.labs.lab04.shape.shapes.Triangle

fun main(){
    val triangle = Triangle(
            vertex1 = Point(2.0, 3.0),
            vertex2 = Point(4.0, -3.0),
            vertex3 = Point(-4.0, 3.0),
            outlineColor = 5,
            fillColor = 3
    )
    println(triangle.getArea())
}