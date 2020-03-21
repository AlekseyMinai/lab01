package com.alexey.minay.labs.lab01.task2.radix

import com.alexey.minay.labs.lab01.task2.validator.ArgsValidator
import com.alexey.minay.labs.lab01.task2.validator.ValidateStatus
import java.math.BigInteger

class RadixChangerImpl(
        private val validator: ArgsValidator,
        private val numbers: List<Char>
): RadixChanger {

    override fun change(oldRadixStr: String, newRadixStr: String, value: String): RadixChangerResult =
            when (validator.validate(oldRadixStr, newRadixStr, value, numbers)) {
                ValidateStatus.INCORRECT_OLD_RADIX -> RadixChangerResult.IncorrectOldRadix
                ValidateStatus.INCORRECT_NEW_RADIX -> RadixChangerResult.IncorrectNewRadix
                ValidateStatus.INCORRECT_VALUE -> RadixChangerResult.IncorrectValue
                ValidateStatus.VALID -> {
                    if (isNegativeValue(value)) {
                        RadixChangerResult.Success("-" +
                                value
                                        .removePrefix("-")
                                        .toBase10From(oldRadixStr.toInt())
                                        .fromBase10To(newRadixStr.toInt()))
                    } else {
                        RadixChangerResult.Success(
                                value
                                        .toBase10From(oldRadixStr.toInt())
                                        .fromBase10To(newRadixStr.toInt()))
                    }
                }
            }

    private fun isNegativeValue(value: String) = value[0] == '-'

    private fun String.toBase10From(base: Int): BigInteger {
        val reverseNum = this.reversed()
        var result = BigInteger("0")
        reverseNum.forEachIndexed { index, charNum ->
            val stringNum = charNum.toUpperCase()
            val base10Num = numbers.indexOf(stringNum).toBigInteger()
            result += base10Num * (base.toBigInteger().pow(index))
        }
        return result
    }

    private fun BigInteger.fromBase10To(base: Int): String {
        var num = this
        var translatedNum = ""
        do {
            val resultAndRemainder = num.divideAndRemainder(base.toBigInteger())
            translatedNum += resultAndRemainder[1].toInt().toStringNum()
            num = resultAndRemainder[0]
            if (num < base.toBigInteger()) {
                translatedNum += num.toInt().toStringNum()
            }
        } while (num >= base.toBigInteger())
        return translatedNum.reversed()
    }

    private fun Int.toStringNum(): Char {
        return numbers[this]
    }

}
