package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.shapes.Shape

interface SolidShape : Shape {
    fun getFillColor(): Int
}