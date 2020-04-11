package com.alexey.minay.labs.lab04.shape.shapes

import com.alexey.minay.labs.lab04.shape.canvas.FxCanvas
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.control.ChoiceBox
import javafx.scene.control.TextField

class MainController {

    @FXML
    private lateinit var canvas: Canvas
    private val fxCanvas: ICanvas by lazy { FxCanvas(canvas) }
    @FXML
    private lateinit var choiceBox: ChoiceBox<String>
    @FXML
    private lateinit var paramsTextField: TextField

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
            showMistake()
            return
        }
        val leftTopSplitString = splitParams[0].removePrefix("leftTop=").split(";")
        val rightBottomSplitString = splitParams[1].removePrefix("rightBottom=").split(";")
        val rectangle = Rectangle(
                leftTop = Point(leftTopSplitString[0].toDouble(), leftTopSplitString[1].toDouble()),
                rightBottom = Point(rightBottomSplitString[0].toDouble(), rightBottomSplitString[0].toDouble()),
                outlineColor = MyColor(0.2, 0.2, 0.2),
                fillColor = MyColor(0.2, 0.2, 0.2)
        )
        rectangle.draw(canvas)
    }

    private fun drawCircle(canvas: ICanvas) {
        val circle = Circle(
                center = Point(200.0, 50.0),
                radius = 30.0,
                outlineColor = MyColor(0.8, 0.2, 0.2),
                fillColor = MyColor(0.2, 0.8, 0.2)
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

    private fun showMistake() {

    }

}