package com.alexey.minay.labs.lab01.radix.validator

interface ArgsValidator {

    fun validate(oldRadixStr: String, newRadixStr: String, value: String, numbers: List<Char>): ValidateStatus

}