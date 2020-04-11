package com.alexey.minay.labs.lab04.shape

import com.alexey.minay.labs.lab04.shape.canvas.FxCanvas
import com.alexey.minay.labs.lab04.shape.canvas.ICanvas
import com.alexey.minay.labs.lab04.shape.shapes.*
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
        primaryStage?.isResizable = false
        primaryStage?.scene = scene

        val infoText = Text("Введите команду для создания фигуры")
        root.children.add(infoText)

        val textField = TextField()
        StackPane.setMargin(textField, Insets(20.0, 20.0, 20.0, 20.0))
        root.children.add(textField)

        val horizontalWidget = HBox()
        val addButton = Button("add")
        horizontalWidget.children.add(addButton)

        val helpButton = Button("help")
        horizontalWidget.children.add(helpButton)
        root.children.add(horizontalWidget)

        val canvas = Canvas(650.0, 500.0)
        root.children.add(canvas)

        helpButton.setOnAction { openHelp(primaryStage) }

        val fxCanvas = FxCanvas(canvas)
        addButton.setOnAction {
            val input = textField.text
            handleInput(input, fxCanvas)
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

    private fun handleInput(input: String?, canvas: ICanvas) {
        val rectangle = Rectangle(
                leftTop = Point(2.0, 2.0),
                rightBottom = Point(100.0, 100.0),
                outlineColor = MyColor(0.2, 0.2, 0.2),
                fillColor = MyColor(0.2, 0.2, 0.2)
        )

        val circle = Circle(
                center = Point(200.0, 50.0),
                radius = 30.0,
                outlineColor = MyColor(0.8, 0.2, 0.2),
                fillColor = MyColor(0.2, 0.8, 0.2)
        )

        val line = LineSegment(
                start = Point(20.0, 50.0),
                end = Point(400.0, 5.0),
                outlineColor = MyColor(0.2, 0.8, 0.2)
        )

        val triangle = Triangle(
                vertex1 = Point(400.0, 300.0),
                vertex2 = Point(350.0, 250.0),
                vertex3 = Point(300.0, 400.0),
                outlineColor = MyColor(0.8, 0.2, 0.2),
                fillColor = MyColor(0.2, 0.8, 0.2)
        )
        rectangle.draw(canvas)
        circle.draw(canvas)
        line.draw(canvas)
        triangle.draw(canvas)
    }

}