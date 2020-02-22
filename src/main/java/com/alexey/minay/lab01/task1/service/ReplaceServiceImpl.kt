package com.alexey.minay.lab01.task1.service

import com.alexey.minay.lab01.task1.domain.ArgsValidator
import com.alexey.minay.lab01.task1.domain.TextReplacer
import com.alexey.minay.lab01.task1.domain.ValidState
import com.alexey.minay.lab01.task1.logger.Logger
import com.alexey.minay.lab01.task1.storage.StorageState
import com.alexey.minay.lab01.task1.storage.TextReader
import com.alexey.minay.lab01.task1.storage.TextWriter
import com.alexey.minay.lab01.task1.utils.exhaustive

class ReplaceServiceImpl(
        val validator: ArgsValidator,
        val logger: Logger,
        val textReader: TextReader,
        val textWriter: TextWriter,
        val textReplacer: TextReplacer
) : ReplaceService {

    override fun replace(args: Array<String>) {
        when (val validState = validator.checkArgs(args)) {
            is ValidState.Invalid -> logger.log(validState.message)
            is ValidState.Valid -> {
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
        textReader.read(inputFile, ::handleResult)
    }

    private fun handleResult(state: StorageState) {

    }
}