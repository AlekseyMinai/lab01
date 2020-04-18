package com.alexey.minay.labs.lab03.calculator.tests

import com.alexey.minay.labs.lab03.calculator.VariableStorage
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class VariableStorageTest {

    private var fromDisplay: String? = null

    private val mockDisplay: (s: String) -> Unit = { fromDisplay = it }

    private val variableStorage = VariableStorage(mockDisplay)

    @Before
    fun setNullInVariables(){
        fromDisplay = null
    }

    @Test
    fun shouldAddVariable() {
        variableStorage.`var`("x")
    }
}