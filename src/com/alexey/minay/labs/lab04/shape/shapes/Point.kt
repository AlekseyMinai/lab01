package com.alexey.minay.labs.lab04.shape.shapes

class Point(
        val x: Double,
        val y: Double
){
    override fun toString(): String {
        return "{$x;$y}"
    }
}