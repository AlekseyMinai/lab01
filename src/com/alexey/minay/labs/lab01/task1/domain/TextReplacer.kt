package com.alexey.minay.labs.lab01.task1.domain

interface TextReplacer {
    fun setParams(search: String, replace: String, sendBuffer: (String) -> Unit)
    fun replace(char: Char)
    fun finish()
}