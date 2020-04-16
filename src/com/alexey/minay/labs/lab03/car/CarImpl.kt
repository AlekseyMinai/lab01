package com.alexey.minay.labs.lab03.car

class CarImpl : Car {

    private var isEngineStarted = false
    private var movementState = MovementState.STAND
    private var speed: Int = 0
    private var gear: Int = 0

    override fun turnOnEngine(): Boolean {
        if (isEngineStarted) {
            return false
        }
        isEngineStarted = true
        return true
    }

    override fun turnOffEngine(): Boolean {
        if (movementState != MovementState.STAND || gear != 0 || !isEngineStarted) {
            return false
        }
        isEngineStarted = false
        return true
    }

    override fun setGear(newGear: Int): Boolean {
        if (newGear < -1 || newGear > 5 || !isEngineStarted
                || (movementState == MovementState.REVERS && speed != 0 && gear != 0)) {
            return false
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
        val gearRange = GEAR_RANGES[newGear.toString()] ?: return false
        if (speed !in gearRange) {
            return false
        }
        gear = newGear
        return true
    }

    override fun setSpeed(newSpeed: Int): Boolean {
        if (!isEngineStarted || speed < 0 || speed > 150) {
            return false
        }
        if (gear == -1) {
            val gearRange = GEAR_RANGES[gear.toString()] ?: return false
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
        val gearRange = GEAR_RANGES[gear.toString()] ?: return false
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

    override fun isEngineStarted() = isEngineStarted

    override fun getMovementState() = movementState.value

    override fun getSpeed() = speed

    override fun getGear() = gear

    enum class MovementState(val value: String) {
        FORWARD("движется вперед"),
        REVERS("движется назад"),
        STAND("стоит")
    }

    companion object{
        private val GEAR_RANGES = mapOf(
                Pair("-1", 0..20),
                Pair("1", 0..30),
                Pair("2", 20..50),
                Pair("3", 30..60),
                Pair("4", 40..90),
                Pair("5", 50..150)
        )
    }

}

