package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IPerson
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.IBus

class Bus(override val quantityPlace: Int) : IBus, Vehicle<IPerson>()