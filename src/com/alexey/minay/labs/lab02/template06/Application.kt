package com.alexey.minay.labs.lab02.template06

fun main(args: Array<String>) {
    val template = "-AABBCCCCCABC+"
    val params = mutableMapOf<String, String>(Pair("A", "[a]"),
            Pair("AA", "[aa]"), Pair("B", "[b]"), Pair("BB", "[bb]"), Pair("C", "[c]"), Pair("CC", "[cc]"))
    expandTemplate(template, params)
}

fun expandTemplate(template: String, params: Map<String, String>): String {
    val a2 = AhoCorasick()
    val paramsList = mutableListOf<String>()
    paramsList.addAll(params.keys)
    a2.initWith(paramsList)
    val results = a2.searchIn(template)

    val listChanges = results.filterIndexed { index, result ->
        if (index+1 < results.size) {
            val next = results[index + 1]
            val currentPlace = result.place
            val nextPlace = next.place - next.word.length
            nextPlace >= currentPlace
        }else{
            true
        }
    }
    println(results)
    println(listChanges)

    return ""
}

data class Result(val place: Int, val word: String)