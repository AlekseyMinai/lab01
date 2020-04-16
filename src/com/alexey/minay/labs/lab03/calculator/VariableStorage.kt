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
        when (val parsedFunction = FunctionParser.parse(functionOrNameFunction)) {
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
            println(variables[key]?.roundTo2Char())
            return
        }
        println(calculateFunction(key))
//        val function = functions[key]
//        if (function != null) {
//            val firstArg = variables[function.firstKeyVariable] ?: Double.NaN
//            val secondArg = variables[function.secondKeyVariable] ?: Double.NaN
//            println(function.function.invoke(firstArg, secondArg).roundTo2Char())
//            return
//        }
    }

    private fun calculateFunction(key: String): Double {
        val function = functions[key]
        if (function != null) {
            val firstArg = variables[function.firstKeyVariable] ?: calculateFunction(function.firstKeyVariable) ?: Double.NaN
            val secondArg = variables[function.secondKeyVariable] ?: calculateFunction(function.secondKeyVariable) ?: Double.NaN
            return function.function.invoke(firstArg, secondArg)
        }
        return Double.NaN
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