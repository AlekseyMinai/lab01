package com.alexey.minay.lab01.task1

import com.alexey.minay.lab01.task1.domain.TextReplacer

private lateinit var textReplacer: TextReplacer

fun main(args: Array<String>){
    textReplacer = TextReplacer("asd", "123")
    print(textReplacer.replace("asadsdfsdfwerasd dfwerasd rewasasdfasdasdasdasdasd"))
}
