package com.alexey.minay.labs.lab06.stringlist

fun main() {
    val list = StringList()
    list.add("1")
    list.add("2")
    list.add("3")
    list.add("4")
    list.add("35")

    list.next()
    list.next()
    list.remove()
    println(list)

    list.remove()
    println(list)

    for (i in list){
        print(i)
    }

}