package com.alexey.minay.labs.lab01.radix.radix

interface RadixChanger {
    fun change(oldRadixStr: String, newRadixStr: String, value: String): RadixChangerResult
}