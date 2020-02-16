package com.alexey.minay.lab01.task1.domain

import com.alexey.minay.lab01.task1.domain.ValidState

interface ArgsValidator {
    fun checkArgs(args: Array<String>): ValidState
}