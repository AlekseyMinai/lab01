package com.alexey.minay.labs.lab01.radix.radix

import com.alexey.minay.labs.lab01.radix.validator.ArgsValidator
import com.alexey.minay.labs.lab01.radix.validator.ValidateStatus
import kotlin.math.pow

class RadixChangerImpl(
        private val validator: ArgsValidator,
        private val numbers: List<Char>
) : RadixChanger {

    override fun change(oldRadixStr: String, newRadixStr: String, value: String): RadixChangerResult =
            when (validator.validate(oldRadixStr, newRadixStr, value, numbers)) {
                ValidateStatus.INCORRECT_OLD_RADIX -> RadixChangerResult.IncorrectOldRadix
                ValidateStatus.INCORRECT_NEW_RADIX -> RadixChangerResult.IncorrectNewRadix
                ValidateStatus.INCORRECT_VALUE -> RadixChangerResult.IncorrectValue
                ValidateStatus.VALID -> {
                    if (isNegativeValue(value)) {
                        val invertBase10Result = value
                                .removePrefix("-")
                                .toBase10From(oldRadixStr.toInt())
                        when (invertBase10Result) {
                            is Base10Result.OverFlow -> RadixChangerResult.TooBigValue
                            is Base10Result.Success -> RadixChangerResult.Success("-" +
                                    invertBase10Result.result
                                            .fromBase10To(newRadixStr.toInt()))
                        }
                    } else {
                        when (val invertBase10Result = value.toBase10From(oldRadixStr.toInt())) {
                            is Base10Result.OverFlow -> RadixChangerResult.TooBigValue
                            is Base10Result.Success -> RadixChangerResult.Success(
                                    invertBase10Result.result
                                            .fromBase10To(newRadixStr.toInt()))
                        }

                    }
                }
            }

    private fun isNegativeValue(value: String) = value[0] == '-'

    private fun String.toBase10From(base: Int): Base10Result {
        val reverseNum = this.reversed()
        var result = 0
        reverseNum.forEachIndexed { index, charNum ->
            val stringNum = charNum.toUpperCase()
            val base10Num = numbers.indexOf(stringNum)
            try {
                val numForSum = Math.multiplyExact(base10Num, base.toDouble().pow(index).toInt())
                result = Math.addExact(result, numForSum)
            } catch (e: Exception) {
                return Base10Result.OverFlow
            }
        }
        return Base10Result.Success(result)
    }

    private fun Int.fromBase10To(base: Int): String {
        var num = this
        var translatedNum = ""
        do {
            val resultAndRemainder = num % base
            translatedNum += resultAndRemainder.toStringNum()
            num /= base
            if (num < base) {
                translatedNum += num.toStringNum()
            }
        } while (num >= base)
        return translatedNum.reversed()
    }

    private fun Int.toStringNum(): Char {
        return numbers[this]
    }

    sealed class Base10Result {
        object OverFlow : Base10Result()
        class Success(val result: Int) : Base10Result()
    }

}
