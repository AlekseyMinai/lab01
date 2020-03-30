package com.alexey.minay.labs.lab03.calculator

import kotlin.math.round

class VariableStorage {

    private val variables = mutableMapOf<String, Double>()
    private val functions = mutableMapOf<String, Function>()

    fun `var`(variableName: String){
        if (variableName.isNullOrEmpty()){
            return
        }
        variables[variableName] = Double.NaN
    }

    fun let(variableName: String, variable: String) {
        try {
            val doubleValue = variable.toDouble()
            variables[variableName] = doubleValue
            return
        } catch (e: Exception) {
            variables[variableName] = variables[variable] ?: Double.NaN
        }
    }

    fun fn(functionName: String, functionOrNameFunction: String) {
        val parsedFunction = FunctionParser.parse(functionOrNameFunction)
        when (parsedFunction) {
            is ParserState.IncorrectFunction -> {
                if (functions[functionOrNameFunction] != null) {
                    functions[functionName] = functions[functionOrNameFunction]!!
                }

            }
            is ParserState.Success -> functions[functionName] = parsedFunction.function
        }
    }

    fun print(key: String) {
        if (variables[key] != null) {
            print(variables[key]?.roundTo2Char())
            return
        }
        if (functions[key] != null) {
            val function = functions[key]
            val firstArg = variables[function?.firstKeyVariable] ?: Double.NaN
            val secondArg = variables[function?.secondKeyVariable] ?: Double.NaN
            println(function?.function?.invoke(firstArg, secondArg)?.roundTo2Char())
            return
        }
    }

    fun printVars() {
        variables.forEach {
            println(it.key + ":" + it.value)
        }
    }

    fun printFns() {
        functions.forEach {
            kotlin.io.print(it.key + ":")
            print(it.key)
        }
    }

    private fun Double.roundTo2Char() = round(this * 100) / 100

}