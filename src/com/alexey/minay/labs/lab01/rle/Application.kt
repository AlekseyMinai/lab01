package com.alexey.minay.labs.lab01.rle

import java.io.File
import java.io.FileOutputStream

fun main(args: Array<String>) {
    if (args.size != 3) {
        print("Incorrect args. " +
                "For packing enter:\n" +
                "java -jar rle.jar pack <input file> <output file>\n" +
                "For unpacking enter:\n" +
                "java -jar rle.jar unpack <input file> <output file>\n")
        return
    }
    when (args[0]) {
        "pack" -> pack(args[1], args[2])
        "unpack" -> unpack(args[1], args[2])
    }
}

fun pack(inputUrl: String, outputUrl: String) {
    val file = File(inputUrl)
    if (!file.exists()) {
        print("File not exist")
        return
    }
    val input = file.inputStream()
    val output = File(outputUrl).outputStream()
    var theSameByteCounter = 0
    var lastByte = -1
    while (input.available() > 0) {
        val byte = input.read()

        if (lastByte != -1 && byte != lastByte) {
            writeBytes(output, theSameByteCounter, lastByte)
            theSameByteCounter = 0
        }

        lastByte = byte
        theSameByteCounter++
        if (theSameByteCounter > 254 || input.available() == 0) {
            writeBytes(output, theSameByteCounter, lastByte)
            theSameByteCounter = 0
            lastByte = -1
        }
    }
    input.close()
    output.close()
}

private fun writeBytes(output: FileOutputStream, quantity: Int, symbol: Int) {
    output.write(quantity)
    output.write(symbol)
}

fun unpack(inputUrl: String, outputUrl: String) {
    val file = File(inputUrl)
    if (!file.exists()) {
        print("File not exist")
        return
    }
    val input = file.inputStream()
    val output = File(outputUrl).outputStream()

    while (input.available() > 0) {
        val quantity = input.read()
        val byte = input.read()
        for (i in 0 until quantity) {
            output.write(byte)
        }
    }

    input.close()
    output.close()
}