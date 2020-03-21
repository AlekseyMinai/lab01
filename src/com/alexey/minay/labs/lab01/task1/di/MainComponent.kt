package com.alexey.minay.labs.lab01.task1.di

import com.alexey.minay.labs.lab01.task1.domain.ArgsValidatorImpl
import com.alexey.minay.labs.lab01.task1.domain.BufferTextReplacer
import com.alexey.minay.labs.lab01.task1.logger.ConsoleLogger
import com.alexey.minay.labs.lab01.task1.storage.FileTextReader
import com.alexey.minay.labs.lab01.task1.storage.FileTextWriter
import com.alexey.minay.labs.lab01.task1.service.ReplaceService
import com.alexey.minay.labs.lab01.task1.service.ReplaceServiceImpl

object MainComponent {
    fun getReplaceService(): ReplaceService =
            ReplaceServiceImpl(
                    validator = ArgsValidatorImpl(),
                    logger = ConsoleLogger(),
                    textReader = FileTextReader(),
                    textWriter = FileTextWriter(),
                    textReplacer = BufferTextReplacer()
            )
}