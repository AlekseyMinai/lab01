package com.alexey.minay.labs.lab02.template06

import org.junit.Assert

fun main(args: Array<String>) {

}

fun expandTemplate(template: String, params: Map<String, String>): String {
    val ahoCorasick = AhoCorasick()
    val paramsList = getListParamsFrom(params)
    ahoCorasick.initWith(paramsList)
    val results = ahoCorasick.searchIn(template)
    return replaceTemplate(template, params, results)
}

private fun getListParamsFrom(mapParams: Map<String, String>): List<String> {
    val params = mutableListOf<String>()
    params.addAll(mapParams.keys)
    return params
}

private fun replaceTemplate(template: String, params: Map<String, String>, results: List<Result>): String {
    var replacedTemplate = template
    var offset = 0
    for (i in results.indices) {
        if (i == results.size - 1) {
            replacedTemplate = replace(replacedTemplate, results[i], params, offset)
            offset = calculateOffset(offset, params, results[i].word)
            continue
        }
        val next = results[i + 1]
        val currentEnd = results[i].place
        val nextStart = next.place - next.word.length
        val isNeedToReplace = nextStart >= currentEnd
        if (isNeedToReplace) {
            replacedTemplate = replace(replacedTemplate, results[i], params, offset)
            offset = calculateOffset(offset, params, results[i].word)
        }
    }
    return replacedTemplate
}

private fun replace(replacedTemplate: String, result: Result, params: Map<String, String>, offset: Int): String {
    val param = result.word
    val startReplacingWord = result.place - param.length + 1 + offset
    val endReplacingWord = result.place + offset
    val replaceRange = startReplacingWord..endReplacingWord
    val value = params[param] ?: return replacedTemplate
    return replacedTemplate.replaceRange(replaceRange, value)
}

private fun calculateOffset(offset: Int, params: Map<String, String>, param: String): Int {
    val value = params[param] ?: return 0
    return offset + value.length - param.length
}