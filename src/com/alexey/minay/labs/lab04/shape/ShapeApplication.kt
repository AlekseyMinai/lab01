package com.alexey.minay.labs.lab04.shape

import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.stage.Modality
import javafx.stage.Stage

class ShapeApplication : Application() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(ShapeApplication::class.java)
        }
    }

    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "Draw"

        val root = VBox()

        val scene = Scene(root, 650.0, 500.0)
        primaryStage?.scene = scene

        val infoText = Text("Введите команду для создания фигуры")
        root.children.add(infoText)

        val textField = TextField()
        StackPane.setMargin(textField, Insets(20.0,20.0,20.0,20.0))
        root.children.add(textField)

        val horizontalWidget = HBox()
        val addButton = Button("add")
        horizontalWidget.children.add(addButton)

        val helpButton = Button("help")
        horizontalWidget.children.add(helpButton)
        root.children.add(horizontalWidget)

        val canvas = Canvas(650.0, 500.0)
        root.children.add(canvas)

        val graphicsContext = canvas.graphicsContext2D

        helpButton.setOnAction { openHelp(primaryStage) }
        addButton.setOnAction {
            val input = textField.text
            handleInput(input)
        }

        primaryStage?.show()
    }

    private fun openHelp(primaryStage: Stage?) {
        val helpWindow = Stage()
        helpWindow.title = "Help"

        val helpWindowRoot = StackPane()
        val scene = Scene(helpWindowRoot, 300.0, 100.0)

        val helpText = Text("\tВведите команду имеющую вид: \n\"rectangle 10.3 20.15 30.7 40.4 ff0000 00ff00\"\n и нажмите кнопу add")
        StackPane.setAlignment(helpText, Pos.TOP_CENTER);
        StackPane.setMargin(helpText, Insets(20.0))
        helpWindowRoot.children.add(helpText)

        helpWindow.scene = scene
        helpWindow.isResizable = false
        helpWindow.initModality(Modality.WINDOW_MODAL)
        helpWindow.initOwner(primaryStage)
        helpWindow.show()

    }

    private fun handleInput(input: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }














    private fun draw(graphicsContext: GraphicsContext?) {
        graphicsContext?.fill = Color.AQUA
        graphicsContext?.stroke = Color.BLUE
        graphicsContext?.lineWidth = 5.0
        graphicsContext?.strokeLine(40.0, 10.0, 10.0, 40.0)
        graphicsContext?.fillPolygon(doubleArrayOf(10.0, 40.0, 10.0, 40.0), doubleArrayOf(210.0, 210.0, 240.0, 240.0), 4)
        graphicsContext?.strokePolygon(doubleArrayOf(10.0, 40.0, 10.0, 40.0), doubleArrayOf(210.0, 210.0, 240.0, 240.0), 4)
    }

    private fun draw2(graphicsContext: GraphicsContext?) {
        graphicsContext?.fill = Color.AQUA
        graphicsContext?.stroke = Color.BLUE
        graphicsContext?.lineWidth = 5.0
        graphicsContext?.strokeLine(140.0, 110.0, 110.0, 40.0)
        graphicsContext?.fillPolygon(doubleArrayOf(150.0, 140.0, 110.0, 140.0), doubleArrayOf(1210.0, 1210.0, 1240.0, 1240.0), 4)
        graphicsContext?.strokePolygon(doubleArrayOf(150.0, 140.0, 110.0, 140.0), doubleArrayOf(1210.0, 1210.0, 1240.0, 1240.0), 4)
    }

}