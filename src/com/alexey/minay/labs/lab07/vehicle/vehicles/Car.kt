package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IPerson
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.ICar

abstract class Car<T : IPerson>: ICar<T>, Vehicle<T>() {

    protected abstract val carModel: MakeOfTheCar

    override fun getMakeOfTheCar() = carModel

}