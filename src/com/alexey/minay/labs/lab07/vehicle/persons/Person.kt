package com.alexey.minay.labs.lab07.vehicle.persons

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IPerson

open class Person(
        protected open val personName: String
) : IPerson {

    override fun getName() = personName

    override fun toString(): String {
        return "Name: $personName"
    }

}