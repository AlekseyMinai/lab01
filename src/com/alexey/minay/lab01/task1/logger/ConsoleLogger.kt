package com.alexey.minay.lab01.task1.logger

class ConsoleLogger : Logger {

    override fun log(message: String) {
        print(message)
    }
}