package com.alexey.minay.labs.lab01.replace.logger

class ConsoleLogger : Logger {

    override fun log(message: String) {
        print(message)
    }
}