package com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces

interface IBaseVehicle {
    fun isEmpty(): Boolean
    fun isFull(): Boolean
    fun getPlaceCount(): Int
    fun getPassengerCount(): Int
    fun removeAllPassengers()
}