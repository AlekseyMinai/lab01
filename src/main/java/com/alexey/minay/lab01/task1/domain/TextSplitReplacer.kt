package com.alexey.minay.lab01.task1.domain

class TextSplitReplacer : TextReplacer {

    private val bufferSize: Int
        get() {
            val minBuffer = Math.max(search.length, replace.length) * 2
            return Math.max(1024, minBuffer)
        }
    private var search: String = ""
    private var replace: String = ""
    private var sendBuffer: (String) -> Unit = {}

    private var buffer = StringBuilder()
    private var sendingBuffer = String()
    private var replaceBuffer = StringBuilder()
    private var counter = 0

    override fun setParams(search: String, replace: String, sendBuffer: (String) -> Unit) {
        this.search = search
        this.replace = replace
        this.sendBuffer = sendBuffer
    }

    override fun replace(char: Char) {
        if (isNotSetParams()) {
            throw RuntimeException("It's necessary to call setParams(search: String, replace: String, sendBuffer: (String) -> Unit) after replace")
        }
        buffer.append(char)
        replaceBuffer.append(char)
        if (replaceBuffer.length > search.length) {
            replaceBuffer.deleteCharAt(0)
        }
        if (isCounterStarted()) {
            counter++
        }

        if (replaceBuffer.toString() == search) {
            when (counter) {
                0 -> {
                    buffer.delete(buffer.length - search.length, buffer.length)
                    buffer.append(replace)
                }
                else -> {

                    val sendingBufferDeleteStart = sendingBuffer.length - search.length - 1 + counter
                    val sendingBufferDeleteEnd = sendingBuffer.length

                    val deletedSymbols = sendingBufferDeleteEnd - sendingBufferDeleteStart

                    sendingBuffer =
                            sendingBuffer.removeRange(sendingBufferDeleteStart, sendingBufferDeleteEnd) + replace

                    buffer.delete(0, search.length - deletedSymbols)
                }
            }
        }

        if (buffer.length == bufferSize) {
            sendingBuffer = buffer.toString()
            buffer.clear()
            startCounter()
        }
        if (isReplaceWithoutSplit()) {
            counter = 0
            sendBuffer(sendingBuffer)
            sendingBuffer = ""
        }


    }

    override fun finish() {
        sendBuffer(sendingBuffer)
        sendBuffer(buffer.toString())
    }

    private fun startCounter() {
        counter++
    }

    private fun isCounterStarted() = counter != 0

    private fun isReplaceWithoutSplit() = counter == search.length

    private fun isNotSetParams() = search.isEmpty() || replace.isEmpty()

}