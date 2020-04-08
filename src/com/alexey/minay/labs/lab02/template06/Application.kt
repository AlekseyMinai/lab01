package com.alexey.minay.labs.lab02.template06

fun main(args: Array<String>) {
    val template = "-AABBCCCCCABC+"
    val params = mutableMapOf(Pair("A", "[a]"),
            Pair("AA", "[aa]"), Pair("B", "[b]"), Pair("BB", "[bb]"), Pair("C", "[c]"), Pair("CC", "[cc]"))

    val template2 = "Hello, %USER_NAME%. Today is {WEEK_DAY}."
    val params2 = mutableMapOf(Pair("%USER_NAME%", "Super %USER_NAME% {WEEK_DAY}"), Pair("{WEEK_DAY}", "Friday. {WEEK_DAY}"))
    println(expandTemplate(template, params))
}

fun expandTemplate(template: String, params: Map<String, String>): String {
    val ahoCorasick = AhoCorasick()
    val paramsList = getListParamsFrom(params)
    ahoCorasick.initWith(paramsList)
    val results = ahoCorasick.searchIn(template)

    var replacedTemplate = template
    var offset = 0
    for (i in results.indices) {
        if (i == results.size - 1){
            val replaceRange = results[i].place - results[i].word.length  + 1 + offset..results[i].place + offset
            val replaceKey = params[results[i].word]
            replacedTemplate = replaceKey?.let { replacedTemplate.replaceRange(replaceRange, it) }.toString()
            offset += params[results[i].word]?.length?.minus(results[i].word.length) ?: 0
            continue
        }
        val next = results[i + 1]
        val currentEnd = results[i].place
        val nextStart = next.place - next.word.length
        val isNeedToReplace = nextStart >= currentEnd
        if (isNeedToReplace) {
            val replaceRange = results[i].place - results[i].word.length  + 1 + offset..results[i].place + offset
            val replaceKey = params[results[i].word]
            replacedTemplate = replaceKey?.let { replacedTemplate.replaceRange(replaceRange, it) }.toString()
            offset += params[results[i].word]?.length?.minus(results[i].word.length) ?: 0
        }
    }
    return replacedTemplate
}

fun getListParamsFrom(mapParams: Map<String, String>): List<String> {
    val params = mutableListOf<String>()
    params.addAll(mapParams.keys)
    return params
}

data class Result(val place: Int, val word: String)