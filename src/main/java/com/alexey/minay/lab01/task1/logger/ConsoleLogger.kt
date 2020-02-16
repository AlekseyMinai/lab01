package com.alexey.minay.lab01.task1.logger

class ConsoleLogger : FailLogger {

    override fun log(message: String) {
        print(message)
    }
}