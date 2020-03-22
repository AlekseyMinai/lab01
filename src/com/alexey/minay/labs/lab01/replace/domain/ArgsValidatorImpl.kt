package com.alexey.minay.labs.lab01.replace.domain

import com.alexey.minay.labs.lab01.replace.logger.LogMessages
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class ArgsValidatorImpl : ArgsValidator {

    override fun checkArgs(args: Array<String>): ValidationState {
        val quantityArgs = args.size
        if (quantityArgs != VALID_ARGS_COUNT) {
            return ValidationState.Invalid(LogMessages.INVALID_ARGS_COUNT)
        }
        val isCorrectInputFile = checkInputFileForExist(File(args[0]))
        if (!isCorrectInputFile) {
            return ValidationState.Invalid(LogMessages.INVALID_FIRST_PARAM)
        }
        val isCorrectOutputPath = checkOutputPathForExist(Paths.get(args[1]).parent)
        if (!isCorrectOutputPath) {
            return ValidationState.Invalid(LogMessages.INVALID_SECOND_PARAM)
        }
        return ValidationState.Valid
    }

    private fun checkInputFileForExist(file: File) = file.exists()

    private fun checkOutputPathForExist(path: Path): Boolean {
        if (Files.exists(path)) {
            return true
        }
        return false
    }

    companion object {
        const val VALID_ARGS_COUNT = 4
    }

}