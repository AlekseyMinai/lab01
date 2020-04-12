package com.alexey.minay.labs.lab04.shape.ui

import com.alexey.minay.labs.lab04.shape.canvas.FxCanvas
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.shapes.*
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ColorPicker
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.stage.Modality
import javafx.stage.Stage
import kotlin.math.pow


class MainController {

    private var startPoint = Point(0.0, 0.0)
    private var endPoint = Point(0.0, 0.0)

    @FXML
    private lateinit var canvas: Canvas
    private val fxCanvas: ICanvas by lazy { FxCanvas(canvas) }
    @FXML
    private lateinit var choiceBox: ChoiceBox<String>
    @FXML
    private lateinit var paramsTextField: TextField
    @FXML
    private lateinit var outlineColorPicker: ColorPicker
    @FXML
    private lateinit var fillColorPicker: ColorPicker
    @FXML
    private lateinit var parent: Parent

    @FXML
    fun onDraw(actionEvent: ActionEvent) {
        drawShape(false)
    }

    @FXML
    fun onClear(actionEvent: ActionEvent) {
        fxCanvas.clearAll()
    }

    @FXML
    fun onMousePressed(mouseEvent: MouseEvent) {
        startPoint = Point(mouseEvent.x, mouseEvent.y)
    }

    @FXML
    fun onMouseReleased(mouseEvent: MouseEvent) {
        endPoint = Point(mouseEvent.x, mouseEvent.y)
        drawShape(true)
    }

    private fun drawShape(isMouseEvent: Boolean) {
        when (choiceBox.value) {
            choiceBox.items[0] -> drawRectangle(isMouseEvent)
            choiceBox.items[1] -> drawCircle(isMouseEvent)
            choiceBox.items[2] -> drawTriangle(isMouseEvent)
            choiceBox.items[3] -> drawLine(isMouseEvent)
        }
    }

    private fun drawRectangle(isMouseEvent: Boolean) {
        val outlineColor = outlineColorPicker.value
        val fillColor = fillColorPicker.value
        var leftTop = startPoint
        var rightBottom = endPoint

        if (!isMouseEvent) {
            val params = paramsTextField.text
            val splitParams = params.split(SPLITTER)
            if (splitParams.size != 2 || !params.contains(LEFT_TOP_PREFIX) || !params.contains(RIGHT_BOTTOM_PREFIX)) {
                showHelpWindow()
                return
            }
            val leftTopSplitString = splitParams[0].removePrefix(LEFT_TOP_PREFIX).split(PARAM_SPLITTER)
            val rightBottomSplitString = splitParams[1].removePrefix(RIGHT_BOTTOM_PREFIX).split(PARAM_SPLITTER)
            leftTop = Point(leftTopSplitString[0].toDouble(), leftTopSplitString[1].toDouble())
            rightBottom = Point(rightBottomSplitString[0].toDouble(), rightBottomSplitString[1].toDouble())
        }

        val rectangle = Rectangle(
                leftTop = leftTop,
                rightBottom = rightBottom,
                outlineColor = MyColor(outlineColor.red, outlineColor.green, outlineColor.blue),
                fillColor = MyColor(fillColor.red, fillColor.green, fillColor.blue)
        )
        rectangle.draw(fxCanvas)
    }

    private fun drawCircle(isMouseEvent: Boolean) {
        val outlineColor = outlineColorPicker.value
        val fillColor = fillColorPicker.value
        var radius = ((endPoint.x - startPoint.x).pow(2) + (endPoint.y - startPoint.y).pow(2)).pow(0.5) / 2
        var center = Point((startPoint.x + endPoint.x) / 2, (startPoint.y + endPoint.y) / 2)
        if (!isMouseEvent) {
            val params = paramsTextField.text
            val splitParams = params.split(SPLITTER)
            if (splitParams.size != 2 || !params.contains(CENTER_PREFIX) || !params.contains(RADIUS_PREFIX)) {
                showHelpWindow()
                return
            }
            val centerSplitString = splitParams[0].removePrefix(CENTER_PREFIX).split(PARAM_SPLITTER)
            center = Point(centerSplitString[0].toDouble(), centerSplitString[1].toDouble())
            radius = splitParams[1].removePrefix(RADIUS_PREFIX).toDouble()
        }

        val circle = Circle(
                center = center,
                radius = radius,
                outlineColor = MyColor(outlineColor.red, outlineColor.green, outlineColor.blue),
                fillColor = MyColor(fillColor.red, fillColor.green, fillColor.blue)
        )
        circle.draw(fxCanvas)
    }

    private fun drawTriangle(isMouseEvent: Boolean) {
        val outlineColor = outlineColorPicker.value
        val fillColor = fillColorPicker.value
        var vertex1 = startPoint
        var vertex2 = endPoint
        var vertex3 = Point(endPoint.x, startPoint.y)
        if (!isMouseEvent) {
            val params = paramsTextField.text
            val splitParams = params.split(SPLITTER)
            if (splitParams.size != 3 || !params.contains(VERTEX1_PREFIX) || !params.contains(VERTEX2_PREFIX) || !params.contains(VERTEX3_PREFIX)) {
                showHelpWindow()
                return
            }
            val vertex1SplitString = splitParams[0].removePrefix(VERTEX1_PREFIX).split(PARAM_SPLITTER)
            val vertex2SplitString = splitParams[1].removePrefix(VERTEX2_PREFIX).split(PARAM_SPLITTER)
            val vertex3SplitString = splitParams[2].removePrefix(VERTEX3_PREFIX).split(PARAM_SPLITTER)
            vertex1 = Point(vertex1SplitString[0].toDouble(), vertex1SplitString[1].toDouble())
            vertex2 = Point(vertex2SplitString[0].toDouble(), vertex2SplitString[1].toDouble())
            vertex3 = Point(vertex3SplitString[0].toDouble(), vertex3SplitString[1].toDouble())
        }

        val triangle = Triangle(
                vertex1 = vertex1,
                vertex2 = vertex2,
                vertex3 = vertex3,
                outlineColor = MyColor(outlineColor.red, outlineColor.green, outlineColor.blue),
                fillColor = MyColor(fillColor.red, fillColor.green, fillColor.blue)
        )
        triangle.draw(fxCanvas)
    }

    private fun drawLine(isMouseEvent: Boolean) {
        val outlineColor = outlineColorPicker.value
        var startPoint = startPoint
        var endPoint = endPoint

        if (!isMouseEvent) {
            val params = paramsTextField.text
            val splitParams = params.split(SPLITTER)
            if (splitParams.size != 2 || !params.contains(START_POINT_PREFIX) || !params.contains(END_POINT_PREFIX)) {
                showHelpWindow()
                return
            }
            val leftTopSplitString = splitParams[0].removePrefix(START_POINT_PREFIX).split(PARAM_SPLITTER)
            val rightBottomSplitString = splitParams[1].removePrefix(END_POINT_PREFIX).split(PARAM_SPLITTER)
            startPoint = Point(leftTopSplitString[0].toDouble(), leftTopSplitString[1].toDouble())
            endPoint = Point(rightBottomSplitString[0].toDouble(), rightBottomSplitString[1].toDouble())
        }
        val line = LineSegment(
                start = startPoint,
                end = endPoint,
                outlineColor = MyColor(outlineColor.red, outlineColor.green, outlineColor.blue)
        )
        line.draw(fxCanvas)
    }

    private fun showHelpWindow() {
        val helpLabel = Label(getHelpText());
        val helpLayout = StackPane()
        helpLayout.children.add(helpLabel)
        val helpScene = Scene(helpLayout, 230.0, 100.0)
        val helpWindow = Stage()
        helpWindow.initModality(Modality.WINDOW_MODAL)
        helpWindow.initOwner(parent.scene.window)
        helpWindow.title = "Help"
        helpWindow.scene = helpScene
        helpWindow.show()
    }

    private fun getHelpText() =
            when (choiceBox.value) {
                choiceBox.items[0] -> RECTANGLE_HELP
                choiceBox.items[1] -> CIRCLE_HELP
                choiceBox.items[2] -> TRIANGLE_HELP
                choiceBox.items[3] -> LINE_HELP
                else -> throw RuntimeException("Unknown shape type")
            }

    companion object {
        const val RECTANGLE_HELP = " Параметры для прямоугольника \nдолжны быть " +
                "следующего вида: \n\"leftTop=30;40 rightBottom=60;70\""
        const val CIRCLE_HELP = " Параметры для круга \nдолжны быть следующего вида: \n" +
                "\"center=30;40 radius=60\""
        const val TRIANGLE_HELP = " Параметры для треугольника \n" +
                "должны быть следующего вида: \n\"vertex1=30;40 vertex2=130;110 vertex3=60;70\""
        const val LINE_HELP = " Параметры для линии \nдолжны быть " +
                "следующего вида: \n\"startPoint=30;40 endPoint=60;70\""

        const val LEFT_TOP_PREFIX = "leftTop="
        const val RIGHT_BOTTOM_PREFIX = "rightBottom="
        const val CENTER_PREFIX = "center="
        const val RADIUS_PREFIX = "radius="
        const val VERTEX1_PREFIX = "vertex1="
        const val VERTEX2_PREFIX = "vertex2="
        const val VERTEX3_PREFIX = "vertex3="
        const val START_POINT_PREFIX = "startPoint="
        const val END_POINT_PREFIX = "endPoint="

        const val SPLITTER = " "
        const val PARAM_SPLITTER = ";"
    }

}