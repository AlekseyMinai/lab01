package com.alexey.minay.labs.lab01.replace.service

import com.alexey.minay.labs.lab01.replace.domain.ArgsValidator
import com.alexey.minay.labs.lab01.replace.domain.TextReplacer
import com.alexey.minay.labs.lab01.replace.domain.ValidationState
import com.alexey.minay.labs.lab01.replace.logger.Logger
import com.alexey.minay.labs.lab01.replace.storage.TextReader
import com.alexey.minay.labs.lab01.replace.storage.TextWriter
import com.alexey.minay.labs.lab01.replace.storage.states.StorageState
import com.alexey.minay.labs.lab01.replace.storage.states.WriterState
import com.alexey.minay.labs.lab01.replace.utils.exhaustive

class ReplaceServiceImpl(
        val validator: ArgsValidator,
        val logger: Logger,
        val textReader: TextReader,
        val textWriter: TextWriter,
        val textReplacer: TextReplacer
) : ReplaceService {

    override fun replace(args: Array<String>) {
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