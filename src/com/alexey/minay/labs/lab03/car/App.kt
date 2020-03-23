package car

fun main(args: Array<String>) {
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
            "info" -> car.printInfo()
            "help" -> printHelp()
            "engineon" -> car.turnOnEngine()
            "engineoff" -> car.turnOffEngine()
            "setgear" -> car.setGear(splittedUserInput[1].toInt())
            "setspeed" -> car.setSpeed(splittedUserInput[1].toInt())
            else -> println("Неизвестная команда")
        }
    }
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

