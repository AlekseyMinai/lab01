package com.alexey.minay.labs.lab07.vehicle.persons

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IPoliceMan

class PoliceMan(
        override val personName: String,
        private val departmentName: String
) : IPoliceMan, Person(personName) {

    override fun getDepartmentName() = departmentName

    override fun toString(): String {
        return "Name: $personName \n$departmentName"
    }

}