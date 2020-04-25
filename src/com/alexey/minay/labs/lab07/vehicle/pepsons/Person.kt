package com.alexey.minay.labs.lab07.vehicle.pepsons

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPerson

open class Person(
        private val name: String
) : IPerson {

    override fun getName() = name

}