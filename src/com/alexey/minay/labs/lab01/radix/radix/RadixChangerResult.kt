package com.alexey.minay.labs.lab01.radix.radix

sealed class RadixChangerResult {
    class Success(val value: String) : RadixChangerResult()
    object IncorrectOldRadix : RadixChangerResult()
    object IncorrectNewRadix : RadixChangerResult()
    object IncorrectValue : RadixChangerResult()
}