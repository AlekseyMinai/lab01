package com.alexey.minay.labs.lab04.shape.tests

import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.shapes.MyColor
import com.alexey.minay.labs.lab04.shape.shapes.Point
import com.alexey.minay.labs.lab04.shape.shapes.Rectangle
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert
import org.junit.Test

class RectangleTest {

    private val rectangle = Rectangle(
            leftTop = Point(3.0, 4.0),
            rightBottom = Point(30.0, 22.0),
            outlineColor = MyColor(0.3, 0.7, 0.2),
            fillColor = MyColor(0.3, 0.7, 0.2)
    )

    @Test
    fun shouldCalculateCorrectArea() {
        Assert.assertEquals(486.0, rectangle.getArea(), 0.001)
    }

    @Test
    fun shouldCalculateCorrectPerimeter() {
        Assert.assertEquals(90.0, rectangle.getPerimeter(), 0.001)
    }

    @Test
    fun shouldInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()
        rectangle.draw(mockCanvas)
        verify(mockCanvas, times(1))
                .drawLine(rectangle.rightTop, rectangle.getLeftTop(), rectangle.getOutlineColor())
        verify(mockCanvas, times(1))
                .drawLine(rectangle.rightTop, rectangle.getRightBottom(), rectangle.getOutlineColor())
        verify(mockCanvas, times(1))
                .drawLine(rectangle.getRightBottom(), rectangle.leftBottom, rectangle.getOutlineColor())
        verify(mockCanvas, times(1))
                .drawLine(rectangle.leftBottom, rectangle.getLeftTop(), rectangle.getOutlineColor())
        verify(mockCanvas, times(1))
                .fillPolygon(mutableListOf(rectangle.rightTop, rectangle.getRightBottom()
                        , rectangle.leftBottom, rectangle.getLeftTop()), rectangle.getFillColor())
        verifyNoMoreInteractions(mockCanvas)
    }

    @Test
    fun shouldNotInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()
        rectangle.draw(mockCanvas)
        verify(mockCanvas, never()).drawCircle(any(), any(), any())
        verify(mockCanvas, never()).fillCircle(any(), any(), any())
    }

}