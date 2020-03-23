package com.alexey.minay.labs.lab03.car

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CarImplTest{

    private lateinit var car: Car

    @Before
    fun setUpCar(){
        car = CarImpl()
    }

    @Test
    fun shouldTurnOnEngine(){
        assert(car.turnOnEngine())
    }

    @Test
    fun shouldNotTurnOnEngineIfAlreadyTurnedOn(){
        car.turnOnEngine()
        assertFalse(car.turnOnEngine())
    }

    @Test
    fun shouldTurnOffEngine(){
        car.turnOnEngine()
        assert(car.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfAlreadyTurnOff(){
        car.turnOnEngine()
        car.turnOffEngine()
        assertFalse(car.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfMoving(){
        car.turnOnEngine()
        car.setGear(1)
        car.setSpeed(10)
        assertFalse(car.turnOffEngine())
    }

    @Test
    fun shouldNotTurnOffEngineIfGearNotNeutral(){
        car.turnOnEngine()
        car.setGear(1)
        assertFalse(car.turnOffEngine())
    }

    @Test
    fun shouldNotSetIncorrectGear(){
        car.turnOnEngine()
        assertFalse(car.setGear(-2))
        assertFalse(car.setGear(6))
    }

    @Test
    fun shouldNotSetGearIfIncorrectSpeedRange(){
        car.turnOnEngine()
        assertFalse(car.setGear(3))
    }

    @Test
    fun shouldSetGear(){
        car.turnOnEngine()
        assert(car.setGear(1))
    }

    @Test
    fun shouldSetSecondGear(){
        car.turnOnEngine()
        car.setGear(1)
        car.setSpeed(20)
        assert(car.setGear(2))
    }

    @Test
    fun shouldNotSetReverseGearIfMoved(){
        car.turnOnEngine()
        car.setGear(1)
        car.setSpeed(20)
        assertFalse(car.setGear(-1))
    }

    @Test
    fun shouldNotSetSpeedIfEngineTurnedOff(){
        assertFalse(car.setSpeed(20))
    }

    @Test
    fun shouldNotSetSpeedIfGearNotSelect(){
        car.turnOnEngine()
        assertFalse(car.setSpeed(20))
    }

    @Test
    fun shouldSetSpeed(){
        car.turnOnEngine()
        car.setGear(1)
        assert(car.setSpeed(20))
    }

    @Test
    fun shouldNotIncreaseSpeedIfSelectNeutral(){
        car.turnOnEngine()
        car.setGear(1)
        car.setSpeed(20)
        car.setGear(0)
        assertFalse(car.setSpeed(25))
    }

    @Test
    fun shouldReduceSpeedIfSelectNeutral(){
        car.turnOnEngine()
        car.setGear(1)
        car.setSpeed(20)
        car.setGear(0)
        assert(car.setSpeed(18))
    }

}