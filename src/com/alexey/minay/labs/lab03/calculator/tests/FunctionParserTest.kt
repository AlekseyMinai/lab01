package com.alexey.minay.labs.lab03.calculator.tests

import com.alexey.minay.labs.lab03.calculator.FunctionParser
import com.alexey.minay.labs.lab03.calculator.ParserState
import org.junit.Assert.*
import org.junit.Test

class FunctionParserTest{

    @Test
    fun shouldReturnSuccessState(){
        val parseResult = FunctionParser.parse("x+y")
        assert(parseResult is ParserState.Success)
    }

    @Test
    fun shouldErrorIfMoreThenOneOperator(){
        val parseResult = FunctionParser.parse("x+y+z")
        assert(parseResult is ParserState.IncorrectFunction)
    }

    @Test
    fun shouldErrorIfDoNotHaveOperator(){
        val parseResult = FunctionParser.parse("asd")
        assert(parseResult is ParserState.IncorrectFunction)
    }

    @Test
    fun shouldCorrectParseResult(){
        val parseResult = FunctionParser.parse("s*r")
        if (parseResult is ParserState.Success){
            val function = parseResult.function
            assertEquals("s", function.firstKeyVariable)
            assertEquals("r", function.secondKeyVariable)
            assertEquals(6.0, function.function.invoke(2.0,3.0), 0.1)
        }else{
            assert(false)
        }
    }

}