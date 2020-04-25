package com.alexey.minay.labs.lab07.vehicle.pepsons

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IRacer

class Racer(
        override val personName: String,
        private var awardCount: Int
) : IRacer, Person(personName) {

    override fun getAwardsCount() = awardCount

    override fun toString(): String {
        return "Name: $personName \nAward count: $awardCount"
    }

}