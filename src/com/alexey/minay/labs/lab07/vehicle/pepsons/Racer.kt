package com.alexey.minay.labs.lab07.vehicle.pepsons

import com.alexey.minay.labs.lab07.vehicle.pepsons.interfaces.IRacer

class Racer(
        name: String,
        private var awardCount: Int
) : IRacer, Person(name) {

    override fun getAwardsCount() = awardCount

}