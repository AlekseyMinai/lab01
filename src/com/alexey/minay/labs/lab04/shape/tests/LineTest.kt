package com.alexey.minay.labs.lab04.shape.tests

import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.shapes.LineSegment
import com.alexey.minay.labs.lab04.shape.shapes.MyColor
import com.alexey.minay.labs.lab04.shape.shapes.Point
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.*
import org.junit.Test


class LineTest {

    private val line = LineSegment(
            start = Point(3.0, 4.0),
            end = Point(30.0, 22.0),
            outlineColor = MyColor(0.3, 0.7, 0.2)
    )

    @Test
    fun shouldReturnLength(){
        assertEquals(32.45, line.getLength(), 0.01)
    }

    @Test
    fun shouldInvokeMethods() {
        val mockCanvas = mock<ICanvas>()
        line.draw(mockCanvas)
        verify(mockCanvas, times(1))
                .drawLine(line.getStartPoint(), line.getEndPoint(), line.getOutlineColor())

        verifyNoMoreInteractions(mockCanvas)
    }

    @Test
    fun shouldNotInvokeCanvasMethods() {
        val mockCanvas = mock<ICanvas>()
        line.draw(mockCanvas)
        verify(mockCanvas, never()).drawCircle(any(), any(), any())
        verify(mockCanvas, never()).fillCircle(any(), any(), any())
        verify(mockCanvas, never()).fillPolygon(any(), any())
    }

}