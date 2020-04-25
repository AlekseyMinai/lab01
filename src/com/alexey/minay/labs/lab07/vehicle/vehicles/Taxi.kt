package com.alexey.minay.labs.lab07.vehicle.vehicles

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPerson
import com.alexey.minay.labs.lab07.vehicle.vehicles.interfaces.ITaxi

class Taxi(override val carModel: MakeOfTheCar, override val quantityPlace: Int) : ITaxi, Car<IPerson>()