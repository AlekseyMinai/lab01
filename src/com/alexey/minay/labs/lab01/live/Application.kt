package com.alexey.minay.labs.lab01.live

import java.util.*


fun main(args: Array<String>){

    val screenBefore = fillEmptyScreenWith(16).fillBeforeScreen()
    printIteration(screenBefore)

}

fun calculateNextItaration(screenBefore: Array<CharArray>){
    for (i in 1 until screenBefore.size - 1){
        for (k in 1 until screenBefore.size - 1){
            screenBefore[i][k]
        }
    }
}

fun Array<CharArray>.fillBeforeScreen(): Array<CharArray> {
    val random = Random()
    for (i in 0 until size){
        for (k in 0 until size){
            if (i in 1..(size - 2) && k in 1..(size - 2)){
                //this[i][k] = if (random.nextBoolean()) '#' else ' '
            }
        }
    }
    this[5][13] = '#'
    this[5][14] = '#'
    this[6][14] = '#'
    this[4][13] = '#'
    return this
}

fun fillEmptyScreenWith(size: Int): Array<CharArray> {
    val screen = mutableListOf<CharArray>()
    for (i in 0..size){
        val row = mutableListOf<Char>()
        for (k in 0..size){
            if (i == 0 || i == size || k == 0 || k == size){
                row.add('*')
            }else{
                row.add(' ')
            }
        }
        screen.add(row.toCharArray())
    }
    return screen.toTypedArray()
}

fun printIteration(screen: Array<CharArray>){
    screen.forEach { chars ->
        chars.forEach {
            print(it)
        }
        println()
    }
}
