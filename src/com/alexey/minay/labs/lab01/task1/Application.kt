package com.alexey.minay.labs.lab01.task1

import com.alexey.minay.labs.lab01.task1.di.MainComponent

open class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val replaceService = MainComponent.getReplaceService()
            replaceService.replace(args)
        }
    }
}


