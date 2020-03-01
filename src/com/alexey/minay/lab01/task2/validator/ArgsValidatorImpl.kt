package com.alexey.minay.lab01.task2.validator

class ArgsValidatorImpl : ArgsValidator {

    override fun validate(oldRadixStr: String, newRadixStr: String, value: String, numbers: List<Char>): ValidateStatus {
        val oldRadix = oldRadixStr.toInt()
        val newRadix = newRadixStr.toInt()
        if (oldRadix !in 2..numbers.size) {
            return ValidateStatus.INCORRECT_OLD_RADIX
        }
        if (newRadix !in 2..numbers.size) {
            return ValidateStatus.INCORRECT_NEW_RADIX
        }
        value.forEachIndexed { index, char ->
            if (char == '-' && index != 0) {
                return ValidateStatus.INCORRECT_VALUE
            }
            val v = numbers.indexOf(char)
            if (v >= oldRadix) {
                return ValidateStatus.INCORRECT_VALUE
            }
        }
        return ValidateStatus.VALID
    }
}