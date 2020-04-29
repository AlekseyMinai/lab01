package com.alexey.minay.labs.lab04.shape.shapes

class MyColor(val red: Double, val green: Double, val blue: Double) {

    init {
        if (red > 1.0 || red < 0) {
            throw IllegalArgumentException("Color's red value ($red) must be in the range 0.0-1.0")
        }
        if (green > 1.0 || green < 0) {
            throw IllegalArgumentException("Color's red value ($green) must be in the range 0.0-1.0")
        }
        if (blue > 1.0 || blue < 0) {
            throw IllegalArgumentException("Color's red value ($blue) must be in the range 0.0-1.0")
        }
    }

    override fun toString(): String {
        return "Color(red = $red, green = $green, blue = $blue)"
    }

}