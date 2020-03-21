package com.alexey.minay.labs.lab01.task1.domain

interface ArgsValidator {
    fun checkArgs(args: Array<String>): ValidationState
}