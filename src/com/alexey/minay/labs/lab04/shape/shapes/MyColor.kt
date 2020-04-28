package com.alexey.minay.labs.lab04.shape.shapes

data class MyColor(val red: Double, val green: Double, val blue: Double) {
    override fun toString(): String {
        return "Color(red = $red, green = $green, blue = $blue)"
    }
}