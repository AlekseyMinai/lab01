package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPerson
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.IBus

class Bus(override var quantityPlace: Int) : IBus, Vehicle<IPerson>()