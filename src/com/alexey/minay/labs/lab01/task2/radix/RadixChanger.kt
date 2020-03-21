package com.alexey.minay.labs.lab01.task2.radix

interface RadixChanger {
    fun change(oldRadixStr: String, newRadixStr: String, value: String): RadixChangerResult
}