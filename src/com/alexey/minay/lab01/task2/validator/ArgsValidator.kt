package com.alexey.minay.lab01.task2.validator

interface ArgsValidator {

    fun validate(oldRadixStr: String, newRadixStr: String, value: String, numbers: List<Char>): ValidateStatus

}