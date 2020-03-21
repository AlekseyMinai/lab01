package com.alexey.minay.labs.lab01.task1.logger

class ConsoleLogger : Logger {

    override fun log(message: String) {
        print(message)
    }
}