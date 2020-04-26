package com.alexey.minay.labs.lab07.vehicle.persons

import com.alexey.minay.labs.lab07.vehicle.persons.interfaces.IRacer

class Racer(
        override val personName: String,
        private var awardCount: Int
) : IRacer, Person(personName) {

    override fun getAwardsCount() = awardCount

    override fun toString(): String {
        return "Name: $personName \nAward count: $awardCount"
    }

}