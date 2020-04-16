package com.alexey.minay.labs.lab03.car

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CarImplTest{

    private lateinit var mCar: Car

    @Before
    fun setUpCar(){
        mCar = CarImpl()
    }

    @Test
    fun shouldTurnOnEngine(){
        assert(mCar.turnOnEngine())
    }

    @Test
    fun shouldNotTurnOnEngineIfAlreadyTurnedOn(){
        mCar.turnOnEngine()
        assertFalse(mCar.turnOnEngine())
    }

    @Test
    fun shouldTurnOffEngine(){
        mCar.turnOnEngine()
        assert(mCar.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfAlreadyTurnOff(){
        mCar.turnOnEngine()
        mCar.turnOffEngine()
        assertFalse(mCar.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfMoving(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(10)
        assertFalse(mCar.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfGearNotNeutral(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        assertFalse(mCar.turnOffEngine())
    }

    @Test
    fun shouldNotSetIncorrectGear(){
        mCar.turnOnEngine()
        assertFalse(mCar.setGear(-2))
        assertFalse(mCar.setGear(6))
    }

    @Test
    fun shouldNotSetGearIfIncorrectSpeedRange(){
        mCar.turnOnEngine()
        assertFalse(mCar.setGear(3))
    }

    @Test
    fun shouldSetGear(){
        mCar.turnOnEngine()
        assert(mCar.setGear(1))
    }

    @Test
    fun shouldSetSecondGear(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        assert(mCar.setGear(2))
    }

    @Test
    fun shouldNotSetReverseGearIfMoved(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        assertFalse(mCar.setGear(-1))
    }

    @Test
    fun shouldNotSetSpeedIfEngineTurnedOff(){
        assertFalse(mCar.setSpeed(20))
    }

    @Test
    fun shouldNotSetSpeedIfGearNotSelect(){
        mCar.turnOnEngine()
        assertFalse(mCar.setSpeed(20))
    }

    @Test
    fun shouldSetSpeed(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        assert(mCar.setSpeed(20))
    }

    @Test
    fun shouldNotIncreaseSpeedIfSelectNeutral(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        mCar.setGear(0)
        assertFalse(mCar.setSpeed(25))
    }

    @Test
    fun shouldReduceSpeedIfSelectNeutral(){
        mCar.turnOnEngine()
        mCar.setGear(1)
        mCar.setSpeed(20)
        mCar.setGear(0)
        assert(mCar.setSpeed(18))
    }

}