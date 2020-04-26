package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IPoliceMan
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.IPoliceCar

class PoliceCar(override val carModel: MakeOfTheCar, override val quantityPlace: Int) : IPoliceCar, Car<IPoliceMan>()