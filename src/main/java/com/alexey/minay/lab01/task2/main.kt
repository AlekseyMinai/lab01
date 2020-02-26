package com.alexey.minay.lab01.task2

fun main(args: Array<String>) {
    val changer = RadixChanger()
    val result = changer.changeRadix(20, 10, "10")
    when(result){
        is RadixChangerResult.Success -> print(result.value)
        else -> print(result)
    }
}

