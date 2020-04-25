package com.alexey.minay.labs.lab07.vehicle.pepsons

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPerson

open class Person(
        protected open val personName: String
) : IPerson {

    override fun getName() = personName

    override fun toString(): String {
        return "Name: $personName"
    }

}