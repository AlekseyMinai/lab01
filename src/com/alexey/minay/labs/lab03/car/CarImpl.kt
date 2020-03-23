package car

class CarImpl : Car {

    var isSwitchedOn = false
    var movementState = MovementState.STAND
    var speed: Int = 0
    var gear: Int = 0

    private val gearRanges = mutableListOf(
            0..20, 0..30, 20..50, 30..60, 40..90, 50..150
    )

    override fun turnOnEngine(): Boolean {
        if (isSwitchedOn) {
            println("Двигатель уже запущен")
            return false
        }
        isSwitchedOn = true
        println("Двигатель запущен")
        return true
    }

    override fun turnOffEngine(): Boolean {
        if (movementState != MovementState.STAND) {
            println("При движении выключить двигатель нельзя")
            return false
        }
        if (gear != 0) {
            println("Двигатель может быть выключен только на нейтральной передаче")
            return false
        }
        if (!isSwitchedOn) {
            println("Двигатель уже заглушен")
            return false
        }
        isSwitchedOn = false
        println("Двигатель заглушен")
        return true
    }

    override fun setGear(newGear: Int): Boolean {
        if (newGear < -1 || newGear > 5) {
            println("Передачи $newGear не существует")
            return false
        }
        if (!isSwitchedOn) {
            println("Передачу можно включить только при запущенном двигателе")
            return false
        }
        if (movementState == MovementState.REVERS && speed != 0 && gear != 0) {
            println("При движении назад можно включить только нейтральную передачу")
        }
        if (newGear == -1) {
            if (speed != 0) {
                println("При включении задней передачи скорость должна быь равна 0")
                return false
            }
            gear = newGear
            println("Включена задняя передача")
            return true
        }
        if (newGear == 0) {
            gear = newGear
            println("Передача переключена на нейтраль")
            return true
        }
        if (speed !in gearRanges[newGear]) {
            println("Невозможно включить $newGear передачу при скорости $speed. Допустимый диапазон ${gearRanges[newGear]}")
            return false
        }
        println("Включена передача ")
        gear = newGear
        return true
    }

    override fun setSpeed(newSpeed: Int): Boolean {
        if (!isSwitchedOn) {
            println("Движение с выключенным двигателем невозможно")
            return false
        }
        if (speed < 0 || speed > 150) {
            println("Заданна невозможная скорость")
            return false
        }
        if (gear == -1) {
            if (newSpeed !in gearRanges[0]) {
                println("Невозможно изменить скорость на этой передаче")
                return false
            }
            if (newSpeed != 0) {
                movementState = MovementState.REVERS
            }
            speed = newSpeed
            println("Скорость изменена на $newSpeed")
            return true
        }
        if (gear == 0) {
            return if (newSpeed > speed) {
                println("Невозможно увеличить скорость на нейтральной передаче")
                false
            }else{
                speed = newSpeed
                println("Затормозили до $speed")
                true
            }
        }
        if (newSpeed !in gearRanges[gear]) {
            println("Невозможно изменить скорость на этой передаче")
            return false
        }
        if (newSpeed == 0) {
            println("Скорость изменена")
            speed = newSpeed
            movementState = MovementState.STAND
            return true
        }
        speed = newSpeed
        movementState = MovementState.FORWARD
        println("Скорость изменена на $newSpeed")
        return true
    }

    override fun printInfo() {
        val engineState = if (isSwitchedOn) "Запущен" else "Заглушен"
        println("Состояние двигателя: $engineState")
        println("Направление движения: ${movementState.name}")
        println("Скорость: $speed")
        println("Передача: $gear")
    }


    enum class MovementState(s: String) {
        FORWARD("движется вперед"),
        REVERS("движется назад"),
        STAND("стоит")
    }
}

