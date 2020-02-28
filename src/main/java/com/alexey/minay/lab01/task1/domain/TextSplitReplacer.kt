package com.alexey.minay.lab01.task1.domain

class TextSplitReplacer(
        private val maxBufferSize: Int = 10
) : TextReplacer {

    private var search: String? = null
    private var replace: String? = null
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
        search?.let { search ->
            buffer.append(char)
            replaceBuffer.append(char)
            if (replaceBuffer.length > search.length) {
                replaceBuffer.deleteCharAt(0)
            }
            if (isCounterStarted()) {
                counter++
            }
            if (buffer.length == maxBufferSize) {
                sendingBuffer = buffer.toString()
                buffer.clear()
                startCounter()
            }
            if (replaceBuffer.toString() == search) {
                when (counter) {
                    0 ->
                        replace?.let { replace ->
                            buffer.delete(buffer.length - replace.length, buffer.length)
                            buffer.append(replace)
                        }
                    else ->
                        replace?.let { replace ->
                            val sendingBufferSuffix = replace.removeRange(replace.length - counter + 1, replace.length)
                            sendingBuffer = sendingBuffer.removeRange(sendingBuffer.length - sendingBufferSuffix.length, sendingBuffer.length) + sendingBufferSuffix
                            val bufferedPrefix = replace.removeRange(0, replace.length - counter+1)
                            buffer.delete(0, bufferedPrefix.length)
                            buffer.append(bufferedPrefix)
                        }
                }
            }
            if (isReplaceWithoutSplit()) {
                counter = 0
                sendBuffer(sendingBuffer)
            }

        }
    }

    override fun finish() {
        sendBuffer(buffer.toString())
    }

    private fun startCounter() {
        counter++
    }

    private fun isCounterStarted() = counter != 0

    private fun isReplaceWithoutSplit() = counter == search?.length

    private fun isNotSetParams() = search.isNullOrEmpty() || replace.isNullOrEmpty()

}