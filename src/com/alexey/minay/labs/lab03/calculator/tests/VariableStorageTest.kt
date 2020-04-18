package com.alexey.minay.labs.lab03.calculator.tests

import com.alexey.minay.labs.lab03.calculator.VariableStorage
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.lang.StringBuilder

class VariableStorageTest {

    private var fromDisplay = mutableListOf<String>()

    private val mockDisplay: (s: String) -> Unit = { fromDisplay.add(it) }

    private val variableStorage = VariableStorage(mockDisplay)

    @Before
    fun clearDisplaying(){
        fromDisplay .clear()
    }

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

    @Test
    fun shouldPrintVariable() {
        val variable = "x"
        val value = "5"
        variableStorage.let(variable, value)
        variableStorage.print(variable)
        assertEquals("5.0\n", fromDisplay.toStringPresentation())
    }

    @Test
    fun shouldPrintVariables() {
        val variable1 = "x1"
        val value1 = "5"
        val variable2 = "x2"
        val value2 = "7"
        variableStorage.let(variable1, value1)
        variableStorage.let(variable2, value2)
        variableStorage.printVars()
        assertEquals("x1: 5.0 \nx2: 7.0 \n", fromDisplay.toStringPresentation())
    }

    @Test
    fun shouldPrintFunction() {
        val variable1 = "x"
        val value1 = "5"
        val variable2 = "y"
        val value2 = "7"
        variableStorage.let(variable1, value1)
        variableStorage.let(variable2, value2)
        val functionName = "f"
        val function = "x*y"
        variableStorage.fn(functionName, function)
        variableStorage.print(functionName)
        assertEquals("35.0\n", fromDisplay.toStringPresentation())
    }

    @Test
    fun shouldPrintFunctions() {
        val variable1 = "x"
        val value1 = "5"
        val variable2 = "y"
        val value2 = "7"
        variableStorage.let(variable1, value1)
        variableStorage.let(variable2, value2)
        val functionName1 = "f1"
        val function1 = "x*y"
        val functionName2 = "f2"
        val function2 = "f1*y"
        variableStorage.fn(functionName1, function1)
        variableStorage.fn(functionName2, function2)
        variableStorage.printFns()
        assertEquals("f1: 35.0 \nf2: 245.0 \n", fromDisplay.toStringPresentation())
    }

    private fun List<String>.toStringPresentation(): String{
        val stringBuilder = StringBuilder()
        this.forEach { stringBuilder.append(it) }
        return stringBuilder.toString()
    }
}