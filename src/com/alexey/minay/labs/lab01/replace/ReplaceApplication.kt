package com.alexey.minay.labs.lab01.replace

import java.io.File
import java.nio.charset.Charset

const val INVALID_ARGS_COUNT = "Check input args. Valid params have form: <input file> <output file> <search string> <replace string>"
const val INVALID_FIRST_PARAM = "Invalid input file"

fun main(args: Array<String>) {
    replace(args)
}

fun replace(args: Array<String>) {
    if (isValidArgs(args))
        startReplaceText(
                inputFileName = args[0],
                outputFileName = args[1],
                search = args[2],
                replace = args[3]
        )
}

fun isValidArgs(args: Array<String>): Boolean {
    val quantityArgs = args.size
    if (quantityArgs != 4) {
        println(INVALID_ARGS_COUNT)
        return false
    }
    if (!File(args[0]).exists()) {
        println(INVALID_FIRST_PARAM)
        return false
    }
    return true
}

private fun startReplaceText(inputFileName: String, outputFileName: String, search: String, replace: String) {
    val bufferedReader = File(inputFileName)
    bufferedReader.forEachLine {
        writeFile(it.replace(search, replace), outputFileName)
    }
}

private fun writeFile(text: String, outputFileName: String){
    val bufferedWriter = File(outputFileName)
    bufferedWriter.appendText("$text\n")
}
