package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IPerson
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.IVehicle

abstract class Vehicle<T : IPerson> : IVehicle<T> {

    private var passengers = mutableListOf<T>()
    protected abstract val quantityPlace: Int

    override fun addPassenger(passenger: T) {
        if (passengers.size >= quantityPlace) {
            throw RuntimeException("logic error")
        }
        passengers.add(passenger)
    }

    override fun getPassenger(index: Int) = passengers[index]

    override fun removePassenger(index: Int) {
        passengers.removeAt(index)
    }

    override fun isEmpty() = passengers.isEmpty()

    override fun isFull() = passengers.size == quantityPlace

    override fun getPlaceCount() = quantityPlace

    override fun getPassengerCount() = passengers.size

    override fun removeAllPassengers() {
        passengers.clear()
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        passengers.forEach { stringBuilder.append(it).append("\n") }
        return stringBuilder.toString()
    }

}