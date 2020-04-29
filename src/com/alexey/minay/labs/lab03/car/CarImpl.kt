package com.alexey.minay.labs.lab03.car

class CarImpl : Car {

    private var mIsEngineStarted = false
    private var mMovementState = MovementState.STAND
    private var mSpeed: Int = 0
    private var mGear: Int = 0

    override fun turnOnEngine(): Boolean {
        if (mIsEngineStarted) {
            return false
        }
        mIsEngineStarted = true
        return true
    }

    override fun turnOffEngine(): Boolean {
        if (mMovementState != MovementState.STAND || mGear != 0 || !mIsEngineStarted) {
            return false
        }
        mIsEngineStarted = false
        return true
    }

    override fun setGear(newGear: Int): Boolean {
        if (newGear < -1 || newGear > 5 || !mIsEngineStarted
                || (mMovementState == MovementState.REVERS && mSpeed != 0 && mGear != 0)) {
            return false
        }
        if (newGear == -1) {
            if (mSpeed != 0) {
                return false
            }
            mGear = newGear
            return true
        }
        if (newGear == 0) {
            mGear = newGear
            return true
        }
        val gearRange = GEAR_RANGES[newGear.toString()] ?: return false
        if (mSpeed !in gearRange) {
            return false
        }
        mGear = newGear
        return true
    }

    override fun setSpeed(newSpeed: Int): Boolean {
        if (!mIsEngineStarted || mSpeed < 0 || mSpeed > 150) {
            return false
        }
        if (mGear == -1) {
            val gearRange = GEAR_RANGES[mGear.toString()] ?: return false
            if (newSpeed !in gearRange) {
                return false
            }
            if (newSpeed != 0) {
                mMovementState = MovementState.REVERS
            }
            mSpeed = newSpeed
            return true
        }
        if (mGear == 0) {
            return if (newSpeed > mSpeed) {
                false
            } else {
                mSpeed = newSpeed
                true
            }
        }
        val gearRange = GEAR_RANGES[mGear.toString()] ?: return false
        if (newSpeed !in gearRange) {
            return false
        }
        if (newSpeed == 0) {
            mSpeed = newSpeed
            mMovementState = MovementState.STAND
            return true
        }
        mSpeed = newSpeed
        mMovementState = MovementState.FORWARD
        return true
    }

    override fun isEngineStarted() = mIsEngineStarted

    override fun getMovementState() = mMovementState.value

    override fun getSpeed() = mSpeed

    override fun getGear() = mGear

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

