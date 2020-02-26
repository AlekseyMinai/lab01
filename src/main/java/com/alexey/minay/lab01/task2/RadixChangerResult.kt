package com.alexey.minay.lab01.task2

sealed class RadixChangerResult {
    class Success(val value: String) : RadixChangerResult()
    object IncorrectOldRadix : RadixChangerResult()
    object IncorrectNewRadix : RadixChangerResult()
    object IncorrectValue : RadixChangerResult()
}