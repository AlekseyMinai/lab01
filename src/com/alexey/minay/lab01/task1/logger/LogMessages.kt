package com.alexey.minay.lab01.task1.logger

object LogMessages {
    const val INVALID_ARGS_COUNT = "Check input args. Valid params have form: <input file> <output file> <search string> <replace string>"
    const val INVALID_FIRST_PARAM = "Invalid input file"
    const val INVALID_SECOND_PARAM = "Invalid output path"

    const val ERROR_READ_FILE = "Error file reading"
    const val ERROR_WRITE_FILE = "Error file writing"
    const val FINISHED_WITH_ERROR_WRITE_FILE = "Finished with error"
    const val FINISHED_WITH_SUCCESS_WRITE_FILE = "Finished with success"
}