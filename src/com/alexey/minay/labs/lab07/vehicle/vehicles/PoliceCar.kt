package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPoliceMan
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.IPoliceCar

class PoliceCar(override val carModel: MakeOfTheCar, override var quantityPlace: Int) : IPoliceCar, Car<IPoliceMan>()