package com.alexey.minay.lab01.task2.radix

interface RadixChanger {
    fun change(oldRadixStr: String, newRadixStr: String, value: String): RadixChangerResult
}