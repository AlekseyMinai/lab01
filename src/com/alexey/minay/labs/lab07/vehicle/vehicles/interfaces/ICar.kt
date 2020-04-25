package com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPerson
import com.alexey.minay.labs.lab07.vehicle.vehicles.MakeOfTheCar

interface ICar<T : IPerson> : IVehicle<T> {
    fun getMakeOfTheCar(): MakeOfTheCar
}