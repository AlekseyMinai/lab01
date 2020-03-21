package com.alexey.minay.labs.lab01.replace.di

import com.alexey.minay.labs.lab01.replace.domain.ArgsValidatorImpl
import com.alexey.minay.labs.lab01.replace.domain.BufferTextReplacer
import com.alexey.minay.labs.lab01.replace.logger.ConsoleLogger
import com.alexey.minay.labs.lab01.replace.storage.FileTextReader
import com.alexey.minay.labs.lab01.replace.storage.FileTextWriter
import com.alexey.minay.labs.lab01.replace.service.ReplaceService
import com.alexey.minay.labs.lab01.replace.service.ReplaceServiceImpl

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