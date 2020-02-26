package com.alexey.minay.lab01.task1.service

import com.alexey.minay.lab01.task1.domain.ArgsValidator
import com.alexey.minay.lab01.task1.domain.TextReplacer
import com.alexey.minay.lab01.task1.domain.ValidState
import com.alexey.minay.lab01.task1.logger.Logger
import com.alexey.minay.lab01.task1.model.TextReader
import com.alexey.minay.lab01.task1.model.TextWriter

class ReplaceServiceImpl(
        val validator: ArgsValidator,
        val logger: Logger,
        val textReader: TextReader,
        val textWriter: TextWriter,
        val textReplacer: TextReplacer
) : ReplaceService {

    override fun replace(args: Array<String>) {
        /*when (val validState = validator.checkArgs(args)) {
            is ValidState.Invalid -> logger.log(validState.message)
        }*/
    }
}