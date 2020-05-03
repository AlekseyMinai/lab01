package com.alexey.minay.labs.lab05.string

import java.util.*

class MyString() {

    private var chars: Array<Char> = arrayOf()

    constructor(chars: Array<Char>) : this() {
        this.chars = chars
    }

    constructor(char: Char) : this() {
        chars = arrayOf(char)
    }

    constructor(any: Any) : this() {
        val stringFromAny = any.toString()
        chars = Array(stringFromAny.length){ stringFromAny[it] }
    }

    constructor(myString: MyString) : this() {
        this.chars = myString.chars
    }

    constructor(myString: String) : this() {
        this.chars = Array(myString.length){ myString[it] }
    }

    fun getLength() = chars.size

    fun getStringData() = chars

    fun subString(start: Int, length: Int): MyString {
        var newArrayLength = length
        if (length > chars.size - start) {
            newArrayLength = chars.size - start
        }
        return MyString(Array(newArrayLength) { chars[it + start] })
    }

    fun clear(){
        chars = arrayOf()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        chars.forEach { builder.append(it) }
        return builder.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MyString

        if (!Arrays.equals(chars, other.chars)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(chars)
    }

    operator fun compareTo(myString2: MyString) = chars.toString().compareTo(myString2.toString())



}