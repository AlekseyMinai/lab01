package com.alexey.minay.labs.lab03.car

interface Car {

    fun turnOnEngine(): Boolean
    fun turnOffEngine(): Boolean
    fun setGear(newGear: Int): Boolean
    fun setSpeed(newSpeed: Int): Boolean
    fun isEngineStarted(): Boolean
    fun getMovementState(): String
    fun getSpeed(): Int
    fun getGear(): Int

}