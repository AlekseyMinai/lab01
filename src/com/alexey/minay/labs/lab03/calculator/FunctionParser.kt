package com.alexey.minay.labs.lab03.calculator

object FunctionParser {

    fun parse(function: String): ParserState {
        var quantityOperators = 0
        var operator = ""
        function.forEach {
            if (it == '+' || it == '-' || it == '*' || it == '/') {
                quantityOperators++
                if (quantityOperators > 1) {
                    return ParserState.IncorrectFunction
                }
                operator = it.toString()
            }
        }
        return when (operator) {
            "" -> ParserState.IncorrectFunction
            else -> ParserState.Success(getFunction(function, operator))
        }
    }

    private fun getFunction(function: String, operator: String): Function {
        val splittedFun = function.split(operator)
        val parseFunction =
                when (operator) {
                    "+" -> FunctionParser::plus
                    "-" -> FunctionParser::minus
                    "*" -> FunctionParser::multiply
                    "/" -> FunctionParser::divide
                    else -> throw Exception("error in operator")
                }
        return Function(
                firstKeyVariable = splittedFun[0].trim(),
                secondKeyVariable = splittedFun[1].trim(),
                function = parseFunction
        )
    }

    private fun plus(firstArg: Double, secondArg: Double) = firstArg + secondArg

    private fun minus(firstArg: Double, secondArg: Double) = firstArg - secondArg

    private fun multiply(firstArg: Double, secondArg: Double) = firstArg * secondArg

    private fun divide(firstArg: Double, secondArg: Double) = firstArg / secondArg

}