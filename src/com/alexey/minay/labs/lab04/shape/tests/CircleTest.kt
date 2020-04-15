package com.alexey.minay.labs.lab04.shape.tests

import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.shapes.Circle
import com.alexey.minay.labs.lab04.shape.shapes.MyColor
import com.alexey.minay.labs.lab04.shape.shapes.Point
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Test

class CircleTest {

    private val circle = Circle(
            center = Point(50.0, 50.0),
            radius = 50.0,
            outlineColor = MyColor(0.3, 0.7, 0.2),
            fillColor = MyColor(0.3, 0.7, 0.2)
    )

    @Test
    fun shouldCalculateArea() {
        assertEquals(7850.0, circle.getArea(), 0.001)
    }

    @Test
    fun shouldCalculatePerimeter() {
        assertEquals(314.0, circle.getPerimeter(), 0.001)
    }

    @Test
    fun shouldInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()
        circle.draw(mockCanvas)
        verify(mockCanvas, times(1))
                .drawCircle(circle.getCenter(), circle.getRadius(), circle.getOutlineColor())
        verify(mockCanvas, times(1))
                .fillCircle(circle.getCenter(), circle.getRadius(), circle.getFillColor())
        verifyNoMoreInteractions(mockCanvas)
    }

    @Test
    fun shouldNotInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()

        circle.draw(mockCanvas)
        verify(mockCanvas, never()).drawLine(any(), any(), any())
        verify(mockCanvas, never()).fillPolygon(anyArray<Point>().toList(), any())
    }

}