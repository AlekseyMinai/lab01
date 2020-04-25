package com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPerson

interface IVehicle<T : IPerson> : IBaseVehicle {
    fun addPassenger(passenger: T)
    fun getPassenger(index: Int): T
    fun removePassenger(index: Int)
}