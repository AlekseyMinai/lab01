package com.alexey.minay.labs.lab02.decode

import java.util.*

fun main() {
    val codeString = readIn()
    print(htmlDecode(codeString))
}

fun readIn(): String {
    print("введите закодированную строку:")
    return readLine().toString()
}

fun htmlDecode(html: String): String {
    return html
            .replace("&quot;", "\"")
            .replace("&apos;", "\'")
            .replace("&it;", "<")
            .replace("&gt;", ">")
            .replace("&amp;", "&")
}

