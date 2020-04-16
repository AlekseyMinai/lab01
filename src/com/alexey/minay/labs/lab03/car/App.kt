package com.alexey.minay.labs.lab03.car

fun main() {
    println("Для завершения работы приложения введите \"...\"")
    println("Для помощи введите help")
    val car = CarImpl()
    var isResume = true
    while (isResume) {
        println()
        println("Введите команду: ")
        val userInput = readLine()
        val splittedUserInput = userInput?.split("_")
        when (splittedUserInput?.get(0)?.toLowerCase()) {
            "..." -> isResume = false
            "info" -> printInfo(car)
            "help" -> printHelp()
            "engineon" -> car.turnOnEngine()
            "engineoff" -> car.turnOffEngine()
            "setgear" -> car.setGear(splittedUserInput[1].toInt())
            "setspeed" -> car.setSpeed(splittedUserInput[1].toInt())
            else -> println("Неизвестная команда")
        }
    }
}

fun printInfo(car: Car) {
    val engineState = if (car.isEngineStarted()) "Запущен" else "Заглушен"
    println("Состояние двигателя: $engineState")
    println("Направление движения: ${car.getMovementState()}")
    println("Скорость: ${car.getSpeed()}")
    println("Передача: ${car.getGear()}")
}

fun printHelp() {
    println("Команды:")
    println("... - Выход")
    println("info - Вывод состояния автомобиля")
    println("EngineOn - Включает двигатель")
    println("EngineOff - Выключить двигатель")
    println("SetGear_<Передача> - Включить заданную передачу")
    println("SetSpeed_<Скорость> - Включить заданную передачу")
}

