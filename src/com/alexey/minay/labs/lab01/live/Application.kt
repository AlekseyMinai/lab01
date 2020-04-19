package com.alexey.minay.labs.lab01.live

import java.io.File

private const val LIVING_CELL_STATE = '#'
private const val DEAD_CELL_STATE = ' '

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        print("Incorrect params. \n" +
                "To correct calculating enter: java -jar life.jar <input file> [<output file>]\n")
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
            var numberOfLivingCell = 0
            if (screen[i - 1][k - 1] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i - 1][k] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i - 1][k + 1] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i][k - 1] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i][k + 1] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i + 1][k - 1] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i + 1][k] == LIVING_CELL_STATE) numberOfLivingCell++
            if (screen[i + 1][k + 1] == LIVING_CELL_STATE) numberOfLivingCell++
            if (numberOfLivingCell == 3) {
                newScreen[i][k] = LIVING_CELL_STATE
            } else if (numberOfLivingCell > 3 || numberOfLivingCell < 2) {
                newScreen[i][k] = DEAD_CELL_STATE
            }
        }
    }
    return newScreen
}

fun copyOf(oldScreen: Array<CharArray>): Array<CharArray> {
    val screen = mutableListOf<CharArray>()
    for (row in oldScreen) {
        val rowChars = row.copyOf()
        screen.add(rowChars)
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
