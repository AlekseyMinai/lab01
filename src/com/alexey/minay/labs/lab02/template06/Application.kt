package com.alexey.minay.labs.lab02.template06

import java.io.File
import java.nio.charset.Charset

fun main(args: Array<String>) {
    if (args.size < 2 || args.size % 2 != 0) {
        println("Incorrect params")
        return
    }
    val file = File(args[0])
    if (!file.exists()) {
        println("File doesn't exist")
        return
    }

    val template = readTextFrom(file)
    val params = getParamsFrom(args)
    val resultText = expandTemplate(template, params)
    write(resultText, args[1])
}

private fun readTextFrom(file: File): String {
    val bufferedReader = file.bufferedReader()
    val iterator = bufferedReader.lineSequence().iterator()
    val template = StringBuilder()
    iterator.forEach {
        template.append(it)
        template.append("\n")
    }
    bufferedReader.close()
    return template.toString()
}

private fun getParamsFrom(args: Array<String>): Map<String, String> {
    val params = mutableMapOf<String, String>()
    for (i in 2 until args.size step 2) {
        params[args[i]] = args[i + 1]
    }
    return params
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

private fun write(text: String, fileName: String) {
    val file = File(fileName)
    val bufferedWriter = file.bufferedWriter(Charset.forName("Windows-1251"))
    bufferedWriter.write(text)
    bufferedWriter.close()
}