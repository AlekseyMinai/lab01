package com.alexey.minay.labs.lab01.task3

import com.alexey.minay.labs.lab01.task3.di.ApplicationComponent

class InvertApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrixService = ApplicationComponent.getService("E:\\labs\\oop\\tasks\\01\\matrix.txt")
            matrixService.invert()
        }
    }
}