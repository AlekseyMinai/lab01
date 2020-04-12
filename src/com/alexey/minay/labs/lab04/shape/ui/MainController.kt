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
import javafx.scene.layout.StackPane
import javafx.stage.Modality
import javafx.stage.Stage


class MainController {

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
        handleInput(fxCanvas)
    }

    @FXML
    fun onClear(actionEvent: ActionEvent) {
        fxCanvas.clearAll()
    }

    private fun handleInput(canvas: ICanvas) {
        when (choiceBox.value) {
            choiceBox.items[0] -> drawRectangle(canvas)
            choiceBox.items[1] -> drawCircle(canvas)
            choiceBox.items[2] -> drawTriangle(canvas)
            choiceBox.items[3] -> drawLine(canvas)
        }
    }

    private fun drawRectangle(canvas: ICanvas) {
        val params = paramsTextField.text
        val splitParams = params.split(" ")
        if (splitParams.size != 2 || !params.contains("leftTop=") || !params.contains("rightBottom=")) {
            showHelpWindow()
            return
        }
        val outlineColor = outlineColorPicker.value
        val fillColor = fillColorPicker.value
        val leftTopSplitString = splitParams[0].removePrefix("leftTop=").split(";")
        val rightBottomSplitString = splitParams[1].removePrefix("rightBottom=").split(";")
        val rectangle = Rectangle(
                leftTop = Point(leftTopSplitString[0].toDouble(), leftTopSplitString[1].toDouble()),
                rightBottom = Point(rightBottomSplitString[0].toDouble(), rightBottomSplitString[1].toDouble()),
                outlineColor = MyColor(outlineColor.red, outlineColor.green, outlineColor.blue),
                fillColor = MyColor(fillColor.red, fillColor.green, fillColor.blue)
        )
        rectangle.draw(canvas)
    }

    private fun drawCircle(canvas: ICanvas) {
        val params = paramsTextField.text
        val splitParams = params.split(" ")
        if (splitParams.size != 2 || !params.contains("center=") || !params.contains("radius=")) {
            showHelpWindow()
            return
        }
        val center = splitParams[0].removePrefix("center=").split(";")
        val radius = splitParams[1].removePrefix("radius=").toDouble()
        val outlineColor = outlineColorPicker.value
        val fillColor = fillColorPicker.value
        val circle = Circle(
                center = Point(center[0].toDouble(), center[1].toDouble()),
                radius = radius,
                outlineColor = MyColor(outlineColor.red, outlineColor.green, outlineColor.blue),
                fillColor = MyColor(fillColor.red, fillColor.green, fillColor.blue)
        )
        circle.draw(canvas)
    }

    private fun drawTriangle(canvas: ICanvas) {
        val triangle = Triangle(
                vertex1 = Point(400.0, 300.0),
                vertex2 = Point(350.0, 250.0),
                vertex3 = Point(300.0, 400.0),
                outlineColor = MyColor(0.8, 0.2, 0.2),
                fillColor = MyColor(0.2, 0.8, 0.2)
        )
        triangle.draw(canvas)
    }

    private fun drawLine(canvas: ICanvas) {
        val line = LineSegment(
                start = Point(20.0, 50.0),
                end = Point(400.0, 5.0),
                outlineColor = MyColor(0.2, 0.8, 0.2)
        )
        line.draw(canvas)
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
                choiceBox.items[0] -> " Параметры для прямоугольника \nдолжны быть " +
                        "следующего вида: \n\"leftTop=30;40 rightBottom=60;70\""
                choiceBox.items[1] -> " Параметры для круга \n" +
                        "должны быть следующего вида: \n" +
                        "\"center=30;40 radius=60\""
                choiceBox.items[2] -> ""
                choiceBox.items[3] -> ""
                else -> throw RuntimeException("Unknown shape type")
            }

}