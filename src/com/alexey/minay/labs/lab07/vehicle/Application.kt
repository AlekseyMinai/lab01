package com.alexey.minay.labs.lab07.vehicle

import com.alexey.minay.labs.lab07.vehicle.persons.Person
import com.alexey.minay.labs.lab07.vehicle.persons.PoliceMan
import com.alexey.minay.labs.lab07.vehicle.persons.Racer
import com.alexey.minay.labs.lab07.vehicle.vehicles.MakeOfTheCar
import com.alexey.minay.labs.lab07.vehicle.vehicles.PoliceCar
import com.alexey.minay.labs.lab07.vehicle.vehicles.Taxi
import java.lang.RuntimeException

fun main() {
    val policeman1 = PoliceMan("John Smith", "Northwest police station")
    val policeCar = PoliceCar(MakeOfTheCar.FORD, 5)
    policeCar.addPassenger(policeman1)
    val policeman2 = PoliceMan("Jim Clark", "Southeast police station")
    policeCar.addPassenger(policeman2)
    println(policeCar)
    val taxi = Taxi(MakeOfTheCar.TOYOTA, 2)
    val taxis = Person("Raja Gandhi")
    val racer = Racer("Michael Schumacher", 155)
    taxi.addPassenger(taxis)
    taxi.addPassenger(racer)

    policeCar.removePassenger(1)
    taxi.removePassenger(0)
    taxi.addPassenger(policeman2)

    try {
        taxi.addPassenger(taxis)
    } catch (e: RuntimeException) {
        println(e.message)
    }

}