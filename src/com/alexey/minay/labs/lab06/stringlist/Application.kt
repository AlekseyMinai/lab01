package com.alexey.minay.labs.lab06.stringlist

fun main() {
    val list = StringList()
    list.add("1")
    list.add("2")
    list.add("3")
    list.add("4")
    list.add("5")


    val iterator = list.iterator()

    while (iterator.hasPrevious()){
        val p = iterator.previous()
        if (p == "2"){
            iterator.set("f")
        }
    }
    while (iterator.hasNext()){
        val p = iterator.next()
        if (p == "3"){
            iterator.set("a")
        }
    }
    while (iterator.hasPrevious()){
        print(iterator.previous())
    }


}