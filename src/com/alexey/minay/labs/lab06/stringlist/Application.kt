package com.alexey.minay.labs.lab06.stringlist

fun main() {
    var mStringList = StringList()

    val element1 = "element1"
    val element2 = "element2"
    val element3 = "element3"
    mStringList.add(element1)
    mStringList.add(element2)
    mStringList.add(element3)
    var iterator = mStringList.iterator()
    iterator.next()
    iterator.next()
    iterator.set("set")
    println(mStringList)


}