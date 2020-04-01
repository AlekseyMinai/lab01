package com.alexey.minay.labs.lab01.live

import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        print("Incorrect params")
        return
    }
    val screenBefore = readScreen(args[0])
    printIteration(screenBefore)
    val screenAfter = calculateNextIteration(screenBefore)
    if (args.size < 2) {
        printIteration(screenAfter)
        return
    }
    writeFile(args[1], screenAfter)
}

fun readScreen(url: String): Array<CharArray> {
    val file = File(url)
    if (!file.exists()) {
        println("File doesn't exist")
    }
    val screen = mutableListOf<CharArray>()
    val bufferedReader = file.bufferedReader()
    val iterator = bufferedReader.lineSequence().iterator()
    iterator.forEach {
        screen.add(it.toCharArray())
    }
    bufferedReader.close()
    return screen.toTypedArray()
}

fun calculateNextIteration(screen: Array<CharArray>): Array<CharArray> {
    val newScreen = copyOf(screen)
    for (i in 1 until screen.size - 1) {
        for (k in 1 until screen.size - 1) {
            var quantityLiveCell = 0
            if (screen[i - 1][k] == '#') quantityLiveCell++
            if (screen[i][k - 1] == '#') quantityLiveCell++
            if (screen[i + 1][k] == '#') quantityLiveCell++
            if (screen[i][k + 1] == '#') quantityLiveCell++
            if (quantityLiveCell == 3) {
                newScreen[i][k] = '#'
            } else if (quantityLiveCell > 3 || quantityLiveCell < 2) {
                newScreen[i][k] = ' '
            }
        }
    }
    return newScreen
}

fun copyOf(oldScreen: Array<CharArray>): Array<CharArray> {
    val screen = mutableListOf<CharArray>()
    for (row in oldScreen) {
        val rowChars = mutableListOf<Char>()
        for (element in row) {
            rowChars.add(element)
        }
        screen.add(rowChars.toCharArray())
    }
    return screen.toTypedArray()
}

fun printIteration(screen: Array<CharArray>) {
    screen.forEach { chars ->
        chars.forEach {
            print(it)
        }
        println()
    }
}

fun writeFile(url: String, screen: Array<CharArray>) {
    val file = File(url)
    val bufferedWriter = file.bufferedWriter()
    screen.forEach {
        bufferedWriter.write(it)
        bufferedWriter.newLine()
    }
    bufferedWriter.close()
}
