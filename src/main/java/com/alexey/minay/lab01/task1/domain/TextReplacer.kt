package com.alexey.minay.lab01.task1.domain

interface TextReplacer {
    fun setParams(search: String, replace: String)
    fun replace(oldText: String): String
}