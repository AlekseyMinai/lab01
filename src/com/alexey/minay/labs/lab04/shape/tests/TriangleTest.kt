package com.alexey.minay.labs.lab04.shape.tests

import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.shapes.MyColor
import com.alexey.minay.labs.lab04.shape.shapes.Point
import com.alexey.minay.labs.lab04.shape.shapes.Triangle
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert
import org.junit.Test

class TriangleTest {

    private val triangle = Triangle(
            vertex1 = Point(3.0, 4.0),
            vertex2 = Point(30.0, 22.0),
            vertex3 = Point(80.0, 212.0),
            outlineColor = MyColor(0.3, 0.7, 0.2),
            fillColor = MyColor(0.3, 0.7, 0.2)
    )

    @Test
    fun shouldCalculateArea() {
        Assert.assertEquals(2115.0, triangle.getArea(), 0.01)
    }

    @Test
    fun shouldCalculatePerimeter() {
        Assert.assertEquals(450.71, triangle.getPerimeter(), 0.01)
    }

    @Test
    fun shouldInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()
        triangle.draw(mockCanvas)
        verify(mockCanvas, times(1))
                .drawLine(triangle.getVertex1(), triangle.getVertex2(), triangle.getOutlineColor())
        verify(mockCanvas, times(1))
                .drawLine(triangle.getVertex2(), triangle.getVertex3(), triangle.getOutlineColor())
        verify(mockCanvas, times(1))
                .drawLine(triangle.getVertex3(), triangle.getVertex1(), triangle.getOutlineColor())

        verify(mockCanvas, times(1))
                .fillPolygon(mutableListOf(triangle.getVertex1(), triangle.getVertex2()
                        , triangle.getVertex3()), triangle.getFillColor())
        verifyNoMoreInteractions(mockCanvas)
    }

    @Test
    fun shouldNotInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()
        triangle.draw(mockCanvas)
        verify(mockCanvas, never()).drawCircle(any(), any(), any())
        verify(mockCanvas, never()).fillCircle(any(), any(), any())
    }
}