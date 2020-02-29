package com.alexey.minay.lab01.task2

import com.alexey.minay.lab01.task2.validator.ArgsValidatorImpl


fun main(args: Array<String>) {
    val validator = ArgsValidatorImpl()
    val changer = RadixChangerImpl(validator)
    val result = changer.change("20", "10", "10")
    when(result){
        is RadixChangerResult.Success -> print(result.value)
        else -> print(result)
    }
}

