package com.alexey.minay.labs.lab02.template06

fun main(args: Array<String>) {
    val template = "ararrab фаывфаы ddrararrrraaba"
    val params = mutableMapOf<String, String>(Pair("arra", "111"),
            Pair("arrab", "22"), Pair("aba", "3333"), Pair("ra", "4"), Pair("aa", "55"))
    expandTemplate(template, params)
}

fun expandTemplate(template: String, params: Map<String, String>): String {
    val a2 = AhoCorasick()
    val paramsList = mutableListOf<String>()
    paramsList.addAll(params.keys)
    a2.initWith(paramsList)
    val result = a2.searchIn(template)
    print(result)
    return ""
}

data class Result(val place: Int, val word: String)