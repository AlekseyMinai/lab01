package com.alexey.minay.labs.lab03.calculator

fun main() {

    val variableStorage = VariableStorage()
    fillFibonacciFunctions(variableStorage)
    var isResume = true
    println("Калькулятор запущен")
    println("Введите комнаду")
    while (isResume) {
        val input = readLine()
        val splittedInput = input?.split(" ")

        if (input.isNullOrEmpty() || splittedInput == null || splittedInput.isEmpty()) {
            println("Некорректный ввод")
            continue
        }
        val command = splittedInput[0]
        val identifier = if (splittedInput.size == 2) splittedInput[1] else ""
        val splittedIdentifier = identifier.split("=")
        val variable = splittedIdentifier[0]
        if (!variable[0].isLetter()) {
            println("Идентификатор не должен начинаться с цифры")
            continue
        }
        val value = if (splittedIdentifier.size == 2) {
            splittedIdentifier[1]
        } else {
            ""
        }
        when (command.toLowerCase()) {
            "..." -> isResume = false
            "var" -> variableStorage.`var`(variable)
            "let" -> variableStorage.let(variable, value)
            "print" -> print(variable, variableStorage)
            "printvars" -> printVars(variableStorage)
            "printfns" -> printFns(variableStorage)
            "fn" -> variableStorage.fn(variable, value)
            else -> println("Некорректный ввод")
        }
    }
}

fun fillFibonacciFunctions(variableStorage: VariableStorage) {
    variableStorage.let("x0", "0")
    variableStorage.let("x1", "1")
    variableStorage.let("x2", "1")
    for (i in 3..100) {
        variableStorage.fn("x$i", "x${i - 1}+x${i - 2}")
    }
}

fun print(key: String, variableStorage: VariableStorage) {
    print(variableStorage.getResult(key) + "\n")
}

fun printVars(variableStorage: VariableStorage) {
    variableStorage.variables.forEach {
        print("${it.key}: ${it.value} \n")
    }
}

fun printFns(variableStorage: VariableStorage) {
    variableStorage.functions.forEach {
        print("${it.key}: ${variableStorage.getResult(it.key)} \n")
    }
}