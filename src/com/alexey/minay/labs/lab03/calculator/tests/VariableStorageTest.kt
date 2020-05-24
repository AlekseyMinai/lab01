package com.alexey.minay.labs.lab03.calculator.tests

import com.alexey.minay.labs.lab03.calculator.VariableStorage
import org.junit.Assert.*
import org.junit.Test

class VariableStorageTest {

    private val variableStorage = VariableStorage()

    @Test
    fun shouldAddVariable() {
        val variable = "x"
        variableStorage.`var`(variable)
        assert(variableStorage.variables.containsKey(variable))
    }

    @Test
    fun shouldAddVariable2() {
        val variable = "x"
        val value = "5"
        variableStorage.let(variable, value)
        assert(variableStorage.variables.containsKey(variable))
    }

    @Test
    fun shouldInitVariable() {
        val variable = "x"
        val value = "5"
        variableStorage.`var`(variable)
        variableStorage.let(variable, value)
        assertEquals(value.toDouble(), variableStorage.variables[variable]!!, 0.1)
    }

    @Test
    fun shouldInitVariableWithAnotherVariable() {
        val variable1 = "x"
        val variable2 = "y"
        val value = "5"
        variableStorage.let(variable1, value)
        variableStorage.let(variable2, variable1)
        assertEquals(value.toDouble(), variableStorage.variables[variable2]!!, 0.1)
    }

    @Test
    fun shouldAddFunction() {
        val functionName = "f"
        val function = "x*y"
        variableStorage.fn(functionName, function)
        assert(variableStorage.functions.containsKey(functionName))
    }

    @Test
    fun shouldNotAddFunction() {
        val functionName = "f"
        val function = "x*y*t"
        variableStorage.fn(functionName, function)
        assertFalse(variableStorage.functions.containsKey(functionName))
    }

    @Test
    fun shouldNotAddFunction2() {
        val functionName = "f"
        val function = "x"
        variableStorage.fn(functionName, function)
        assertFalse(variableStorage.functions.containsKey(functionName))
    }

    @Test
    fun shouldNotAddFunction3() {
        val functionName = "f"
        val function = "5"
        variableStorage.fn(functionName, function)
        assertFalse(variableStorage.functions.containsKey(functionName))
    }

}