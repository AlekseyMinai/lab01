package com.alexey.minay.labs.lab01.replace

import com.alexey.minay.labs.lab01.replace.domain.*
import com.alexey.minay.labs.lab01.replace.logger.ConsoleLogger
import com.alexey.minay.labs.lab01.replace.logger.Logger
import com.alexey.minay.labs.lab01.replace.storage.FileTextReader
import com.alexey.minay.labs.lab01.replace.storage.FileTextWriter
import com.alexey.minay.labs.lab01.replace.storage.TextReader
import com.alexey.minay.labs.lab01.replace.storage.TextWriter
import com.alexey.minay.labs.lab01.replace.storage.states.StorageState
import com.alexey.minay.labs.lab01.replace.storage.states.WriterState
import com.alexey.minay.labs.lab01.replace.utils.exhaustive



open class ReplaceApplication {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            ReplaceApplication().replace(args)
        }
    }

    private val validator: ArgsValidator = ArgsValidatorImpl()
    private val logger: Logger = ConsoleLogger()
    private val textReader: TextReader = FileTextReader()
    private val textWriter: TextWriter = FileTextWriter()
    private val textReplacer: TextReplacer = BufferTextReplacer()

    fun replace(args: Array<String>) {
        val validState = validator.checkArgs(args)
        when (validState) {
            is ValidationState.Invalid -> logger.log(validState.message)
            is ValidationState.Valid -> {
                startReplaceText(
                        inputFile = args[0],
                        outputFile = args[1],
                        search = args[2],
                        replace = args[3]
                )
            }
        }.exhaustive()
    }

    private fun startReplaceText(inputFile: String, outputFile: String, search: String, replace: String) {
        textReplacer.setParams(search, replace, ::write)
        textWriter.setParams(outputFile)
        textReader.readChar(inputFile, ::handleReadingResult)
    }

    private fun handleReadingResult(state: StorageState) {
        when (state) {
            is StorageState.Error -> logger.log(state.message)
            is StorageState.Success -> textReplacer.replace(state.char)
            is StorageState.Closed -> {
                textReplacer.finish()
                val writerState = textWriter.close()
                handleWritingResult(writerState)
            }
        }
    }

    private fun write(text: String) {
        val writerState = textWriter.saveText(text)
        handleWritingResult(writerState)
    }

    private fun handleWritingResult(writerState: WriterState) {
        when (writerState) {
            is WriterState.Error -> logger.log(writerState.message)
            is WriterState.Finished -> logger.log(writerState.message)
        }
    }

}



