package com.alexey.minay.labs.lab04.shape

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage


class ShapeApplication : Application() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(ShapeApplication::class.java)
        }
    }

    override fun start(primaryStage: Stage?) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("main.fxml"))
        val scene = Scene(root)

        primaryStage?.scene = scene;

        primaryStage?.title = "Hello JavaFX";
        primaryStage?.width = 1300.0;
        primaryStage?.height = 800.0;
        primaryStage?.isResizable = false
        primaryStage?.show();

    }

}