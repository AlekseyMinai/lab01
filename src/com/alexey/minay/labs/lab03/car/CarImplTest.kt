package com.alexey.minay.labs.lab03.car

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class CarImplTest {

    private lateinit var mCar: Car

    @Before
    fun setUpCar() {
        mCar = CarImpl()
    }

    @Test
    fun shouldTurnOnEngine() {
        mCar.turnOnEngine()
        assert(mCar.isEngineStarted())
    }

    @Test
    fun shouldNotTurnOnEngineIfAlreadyTurnedOn() {
        mCar.turnOnEngine()
        assertFalse(mCar.turnOnEngine())
    }

    @Test
    fun shouldTurnOffEngine() {
        mCar.turnOnEngine()
        mCar.turnOffEngine()
        assertFalse(mCar.isEngineStarted())
    }

    @Test
    fun shouldNotTurnOffEngineIfAlreadyTurnOff() {
        mCar.turnOnEngine()
        mCar.turnOffEngine()
        assertFalse(mCar.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfMoving() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(10)
        mCar.turnOffEngine()
        assert(mCar.isEngineStarted())
    }

    @Test
    fun shouldNotTurnOffEngineIfGearNotNeutral() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.turnOffEngine()
        assert(mCar.isEngineStarted())
    }

    @Test
    fun shouldNotSetIncorrectGear() {
        mCar.turnOnEngine()
        mCar.setGear(-1)
        mCar.setSpeed(20)
        mCar.setGear(-1)
        assertEquals(-1, mCar.getGear())
    }

    @Test
    fun shouldNotSetIncorrectGear2() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(30)
        mCar.setGear(2)
        mCar.setSpeed(50)
        mCar.setGear(3)
        mCar.setSpeed(60)
        mCar.setGear(4)
        mCar.setSpeed(90)
        mCar.setGear(5)
        mCar.setSpeed(150)
        mCar.setGear(6)
        assertEquals(5, mCar.getGear())
    }

    @Test
    fun shouldNotSetGearIfIncorrectSpeedRange() {
        mCar.turnOnEngine()
        mCar.setGear(3)
        assertEquals(0, mCar.getGear())
    }

    @Test
    fun shouldSetGear() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        assertEquals(1, mCar.getGear())
    }

    @Test
    fun shouldSetSecondGear() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        mCar.setGear(2)
        assertEquals(2, mCar.getGear())
    }

    @Test
    fun shouldNotSetReverseGearIfMoved() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        assertFalse(mCar.setGear(-1))
    }

    @Test
    fun shouldNotSetSpeedIfEngineTurnedOff() {
        mCar.setSpeed(20)
        assertEquals(0, mCar.getSpeed())
    }

    @Test
    fun shouldNotSetSpeedIfGearNotSelect() {
        mCar.turnOnEngine()
        assertFalse(mCar.setSpeed(20))
    }

    @Test
    fun shouldSetSpeed() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        assertEquals(20, mCar.getSpeed())
    }

    @Test
    fun shouldNotIncreaseSpeedIfSelectNeutral() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        mCar.setGear(0)
        mCar.setSpeed(25)
        assertEquals(20, mCar.getSpeed())
    }

    @Test
    fun shouldReduceSpeedIfSelectNeutral() {
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        mCar.setGear(0)
        mCar.setSpeed(18)
        assertEquals(18, mCar.getSpeed())
    }

}