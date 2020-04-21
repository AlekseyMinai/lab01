package com.alexey.minay.labs.lab06.stringlist

fun main() {
    val list = StringList()
    list.add("1")
    list.add("2")
    list.add("3")
    list.add("3")
    list.add("3")

    println(list)
    list.add("3")
    println(list)
    list.add("4")
    println(list)
    list.remove()
    println(list)
    list.remove()
    println(list)
    list.set("5")
    println(list)
    list.set("6")
    println(list)
}