package com.alexey.minay.labs.lab03.calculator

import kotlin.math.round

class VariableStorage {

    var variables = mutableMapOf<String, Double>()
        private set
    var functions = mutableMapOf<String, Function>()
        private set

    fun `var`(variableName: String) {
        if (variableName.isNullOrEmpty()) {
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

    internal fun getResult(key: String): String {
        if (variables[key] != null) {
            return variables[key]?.roundTo2Char().toString()
        }
        return calculateFunction(key).roundTo2Char().toString()
    }

    private fun calculateFunction(key: String): Double {
        val function = functions[key]
        if (function != null) {
            var result = function.lazyResult
            if (result != null) {
                return result
            }
            val firstArg = variables[function.firstKeyVariable]
                    ?: calculateFunction(function.firstKeyVariable)
                    ?: Double.NaN
            val secondArg = variables[function.secondKeyVariable]
                    ?: calculateFunction(function.secondKeyVariable)
                    ?: Double.NaN
            result = function.function.invoke(firstArg, secondArg)
            function.lazyResult = result
            return result
        }
        return Double.NaN
    }

    private fun Double.roundTo2Char() = round(this * 100) / 100

}