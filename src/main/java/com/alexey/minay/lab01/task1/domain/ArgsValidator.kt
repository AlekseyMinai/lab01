package com.alexey.minay.lab01.task1.domain

interface ArgsValidator {
    fun checkArgs(args: Array<String>): ValidationState
}