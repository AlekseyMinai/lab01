package com.alexey.minay.lab01.task2.validator

interface ArgsValidator {

    fun validate(oldRadix: Int, newRadix: Int, value: String, numbers: List<Char>): ValidateStatus

}