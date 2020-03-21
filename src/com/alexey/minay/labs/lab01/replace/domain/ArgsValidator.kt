package com.alexey.minay.labs.lab01.replace.domain

interface ArgsValidator {
    fun checkArgs(args: Array<String>): ValidationState
}