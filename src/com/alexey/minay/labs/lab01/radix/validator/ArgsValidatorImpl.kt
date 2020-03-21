package com.alexey.minay.labs.lab01.radix.validator

class ArgsValidatorImpl : ArgsValidator {

    override fun validate(oldRadixStr: String, newRadixStr: String, value: String, numbers: List<Char>): ValidateStatus {
        val oldRadix = toIntRadix(oldRadixStr)
        val newRadix = toIntRadix(oldRadixStr)

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

    private fun toIntRadix(radix: String): Int {
        return try {
            radix.toInt()
        } catch (e: Exception) {
            -1
        }
    }

}