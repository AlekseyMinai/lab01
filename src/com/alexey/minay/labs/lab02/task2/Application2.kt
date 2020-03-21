package com.alexey.minay.labs.lab02.task2

import java.util.*

fun main(args: Array<String>) {
    val codeString = readIn()
    //val s = "Car &it;says&gt; &quot;Meow&quot; M&amp;M&apos;s"
    print(htmlDecode(codeString))
}

fun readIn(): String {
    print("введите закодированную строку:")
    val scanner = Scanner(System.`in`)
    return scanner.nextLine()
}

fun htmlDecode(html: String): String {
    return html.replace("&quot;", "\"")
            .replace("&apos;", "\'")
            .replace("&it;", "<")
            .replace("&gt;", ">")
            .replace("&amp;", "&")
}

