package com.alexey.minay.labs.lab07.vehicle.pepsons

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IPoliceMan

class PoliceMan(
        name: String,
        private val departmentName: String
) : IPoliceMan, Person(name) {

    override fun getDepartmentName() = departmentName

}