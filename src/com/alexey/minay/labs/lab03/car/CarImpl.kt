package com.alexey.minay.labs.lab03.car

class CarImpl : Car {

    var isEngineStarted = false
    var movementState = MovementState.STAND
    var speed: Int = 0
    var gear: Int = 0

    override fun turnOnEngine(): Boolean {
        if (isEngineStarted) {
            return false
        }
        isEngineStarted = true
        return true
    }

    override fun turnOffEngine(): Boolean {
        if (movementState != MovementState.STAND) {
            return false
        }
        if (gear != 0) {
            return false
        }
        if (!isEngineStarted) {
            return false
        }
        isEngineStarted = false
        return true
    }

    override fun setGear(newGear: Int): Boolean {
        if (newGear < -1 || newGear > 5) {
            return false
        }
        if (!isEngineStarted) {
            return false
        }
        if (movementState == MovementState.REVERS && speed != 0 && gear != 0) {
        }
        if (newGear == -1) {
            if (speed != 0) {
                return false
            }
            gear = newGear
            return true
        }
        if (newGear == 0) {
            gear = newGear
            return true
        }
        val gearRange = gearRanges[newGear.toString()] ?: return false
        if (speed !in gearRange) {
            return false
        }
        gear = newGear
        return true
    }

    override fun setSpeed(newSpeed: Int): Boolean {
        if (!isEngineStarted) {
            return false
        }
        if (speed < 0 || speed > 150) {
            return false
        }
        if (gear == -1) {
            val gearRange = gearRanges["-1"] ?: return false
            if (newSpeed !in gearRange) {
                return false
            }
            if (newSpeed != 0) {
                movementState = MovementState.REVERS
            }
            speed = newSpeed
            return true
        }
        if (gear == 0) {
            return if (newSpeed > speed) {
                false
            } else {
                speed = newSpeed
                true
            }
        }
        val gearRange = gearRanges[gear.toString()] ?: return false
        if (newSpeed !in gearRange) {
            return false
        }
        if (newSpeed == 0) {
            speed = newSpeed
            movementState = MovementState.STAND
            return true
        }
        speed = newSpeed
        movementState = MovementState.FORWARD
        return true
    }

    override fun printInfo() {
        val engineState = if (isEngineStarted) "Запущен" else "Заглушен"
        println("Состояние двигателя: $engineState")
        println("Направление движения: ${movementState.value}")
        println("Скорость: $speed")
        println("Передача: $gear")
    }

    enum class MovementState(val value: String) {
        FORWARD("движется вперед"),
        REVERS("движется назад"),
        STAND("стоит")
    }

    companion object{
        private val gearRanges = mutableMapOf(
                Pair("-1", 0..20),
                Pair("1", 0..30),
                Pair("2", 20..50),
                Pair("3", 30..60),
                Pair("4", 40..90),
                Pair("5", 50..150)
        )
    }

}

