package com.alexey.minay.lab01.task1.domain

import com.alexey.minay.lab01.task1.logger.LogMessages
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class ArgsValidatorImpl : ArgsValidator {

    override fun checkArgs(args: Array<String>): ValidationState {
        val countArgs = args.size
        if (countArgs != VALID_ARGS_COUNT) {
            return ValidationState.Invalid(LogMessages.INVALID_ARGS_COUNT)
        }
        val isCorrectInputFile = checkInputFile(File(args[0]))
        if (!isCorrectInputFile) {
            return ValidationState.Invalid(LogMessages.INVALID_FIRST_PARAM)
        }
        val isCorrectOutputPath = checkOutputPath(args[1])
        if (!isCorrectOutputPath) {
            return ValidationState.Invalid(LogMessages.INVALID_SECOND_PARAM)
        }
        return ValidationState.Valid
    }

    private fun checkInputFile(file: File) = file.exists()

    private fun checkOutputPath(url: String): Boolean {
        val path = Paths.get(url).parent
        if (Files.exists(path)) {
            return true
        }
        return false
    }

    companion object {
        const val VALID_ARGS_COUNT = 4
    }

}