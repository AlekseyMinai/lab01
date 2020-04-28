package com.alexey.minay.labs.lab04.shape

import com.alexey.minay.labs.lab04.shape.shapes.*

private val mShapes = mutableListOf<Shape>()
private const val RECTANGLE_INPUT = "rectangle 10.3 20.15 30.7 40.4 ff0000 00ff00"
private const val TRIANGLE_INPUT = "triangle 10.3 20.15 30.7 40.4 212.7 221.4 ff0000 00ff00"
private const val CIRCLE_INPUT = "circle 10.3 20.15 10.7 ff0000 00ff00"
private const val LINE_INPUT = "line 10.3 20.15 10.7 10.7 ff0000"
private const val FF = 255.0

fun main() {
    println("Hello! Input shape params. Examples:")
    println(RECTANGLE_INPUT)
    println(TRIANGLE_INPUT)
    println(CIRCLE_INPUT)
    println(LINE_INPUT)
    println("To exit print ctrl+d")
    var isResumed = true
    while (isResumed) {
        val input = readLine()
        when {
            input == null -> {
                isResumed = false
                println("Фигура с наибольшей площадью: ${(mShapes.maxBy { it.getArea() }).toString()}")
                println("Фигура с наименьшем периодом: ${(mShapes.minBy { it.getArea() }).toString()}")
            }
            else -> handleInput(input)
        }
    }
}

fun handleInput(input: String) {
    val splittedInput = input.split(" ")
    if (splittedInput.isEmpty()) {
        return
    }
    when (splittedInput[0]) {
        "rectangle" -> parseRectangle(splittedInput)?.let { mShapes.add(it) }
        "triangle" -> parseTriangle(splittedInput)?.let { mShapes.add(it) }
        "circle" -> parseCircle(splittedInput)?.let { mShapes.add(it) }
        "line" -> parseLine(splittedInput)?.let { mShapes.add(it) }
        else -> println("Unfamiliar shape")
    }
}

private fun parseRectangle(splittedInput: List<String>): Rectangle? {
    if (splittedInput.size != 7) {
        println("Incorrect params. Example: \n $RECTANGLE_INPUT")
        return null
    }
    val pointCoordinateList = splittedInput.subList(1, 5).toDouble()
    val listColors = splittedInput.subList(5, 7).toMyColor()
    if (pointCoordinateList.size != 4 || listColors.size != 2) {
        println("Incorrect params. Example: \n $RECTANGLE_INPUT")
        return null
    }
    return Rectangle(
            leftTop = Point(pointCoordinateList[0], pointCoordinateList[1]),
            rightBottom = Point(pointCoordinateList[2], pointCoordinateList[3]),
            outlineColor = listColors[0],
            fillColor = listColors[1]
    )
}

fun parseTriangle(splittedInput: List<String>): Triangle? {
    if (splittedInput.size != 9) {
        println("Incorrect params. Example: \n $TRIANGLE_INPUT")
        return null
    }
    val pointCoordinateList = splittedInput.subList(1, 7).toDouble()
    val listColors = splittedInput.subList(7, 9).toMyColor()
    if (pointCoordinateList.size != 6 || listColors.size != 2) {
        println("Incorrect params. Example: \n $TRIANGLE_INPUT")
        return null
    }
    return Triangle(
            vertex1 = Point(pointCoordinateList[0], pointCoordinateList[1]),
            vertex2 = Point(pointCoordinateList[2], pointCoordinateList[3]),
            vertex3 = Point(pointCoordinateList[4], pointCoordinateList[5]),
            outlineColor = listColors[0],
            fillColor = listColors[1]
    )
}

fun parseCircle(splittedInput: List<String>): Circle? {
    if (splittedInput.size != 6) {
        println("Incorrect params. Example: \n $CIRCLE_INPUT")
        return null
    }
    val pointCoordinateList = splittedInput.subList(1, 4).toDouble()
    val listColors = splittedInput.subList(4, 6).toMyColor()
    if (pointCoordinateList.size != 3 || listColors.size != 2) {
        println("Incorrect params. Example: \n $CIRCLE_INPUT")
        return null
    }
    return Circle(
            center = Point(pointCoordinateList[0], pointCoordinateList[1]),
            radius = pointCoordinateList[2],
            outlineColor = listColors[0],
            fillColor = listColors[1]
    )
}

fun parseLine(splittedInput: List<String>): LineSegment? {
    if (splittedInput.size != 6) {
        println("Incorrect params. Example: \n $LINE_INPUT")
        return null
    }
    val pointCoordinateList = splittedInput.subList(1, 5).toDouble()
    val outlineColor = splittedInput[5].toMyColor()
    if (pointCoordinateList.size != 4 || outlineColor == null) {
        println("Incorrect params. Example: \n $RECTANGLE_INPUT")
        return null
    }
    return LineSegment(
            start = Point(pointCoordinateList[0], pointCoordinateList[1]),
            end = Point(pointCoordinateList[2], pointCoordinateList[3]),
            outlineColor = outlineColor
    )
}

private fun List<String>.toMyColor(): List<MyColor> =
        mapNotNull {
            if (it.length == 6) {
                it.toMyColor()
            } else {
                null
            }
        }

private fun String.toMyColor(): MyColor? =
        try {
            MyColor(
                    red = Integer.parseInt(this.substring(0, 1), 16).dec() / FF,
                    green = Integer.parseInt(this.substring(2, 3), 16).dec() / FF,
                    blue = Integer.parseInt(this.substring(4, 5), 16).dec() / FF
            )
        } catch (e: Exception) {
            null
        }


private fun List<String>.toDouble() =
        mapNotNull {
            try {
                it.toDouble()
            } catch (e: Exception) {
                null
            }
        }
