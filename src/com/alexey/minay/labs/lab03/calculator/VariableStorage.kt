package com.alexey.minay.labs.lab03.calculator

import kotlin.math.round

class VariableStorage {

    private val mVariables = mutableMapOf<String, Double>()
    private val mFunctions = mutableMapOf<String, Function>()

    fun `var`(variableName: String) {
        if (variableName.isNullOrEmpty()) {
            return
        }
        mVariables[variableName] = Double.NaN
    }

    fun let(variableName: String, variable: String) {
        try {
            val doubleValue = variable.toDouble()
            mVariables[variableName] = doubleValue
            return
        } catch (e: Exception) {
            mVariables[variableName] = mVariables[variable] ?: Double.NaN
        }
    }

    fun fn(functionName: String, functionOrNameFunction: String) {
        when (val parsedFunction = FunctionParser.parse(functionOrNameFunction)) {
            is ParserState.IncorrectFunction -> {
                if (mFunctions[functionOrNameFunction] != null) {
                    mFunctions[functionName] = mFunctions[functionOrNameFunction]!!
                }

            }
            is ParserState.Success -> mFunctions[functionName] = parsedFunction.function
        }
    }

    fun print(key: String) {
        if (mVariables[key] != null) {
            println(mVariables[key]?.roundTo2Char())
            return
        }
        println(calculateFunction(key).roundTo2Char())
    }

    fun printVars() {
        mVariables.forEach {
            println(it.key + ":" + it.value)
        }
    }

    fun printFns() {
        mFunctions.forEach {
            kotlin.io.print(it.key + ":")
            print(it.key)
        }
    }

    private fun calculateFunction(key: String): Double {
        val function = mFunctions[key]
        if (function != null) {
            var result = function.lazyResult
            if (result != null) {
                return result
            }
            val firstArg = mVariables[function.firstKeyVariable]
                    ?: calculateFunction(function.firstKeyVariable)
                    ?: Double.NaN
            val secondArg = mVariables[function.secondKeyVariable]
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