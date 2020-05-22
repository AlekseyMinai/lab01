package com.alexey.minay.labs.lab05.string

import java.util.*

class MyString: Iterable<Char>{

    private var mChars: Array<Char> = arrayOf()

    constructor(chars: Array<Char>) {
        this.mChars = chars
    }

    constructor(char: Char) {
        mChars = arrayOf(char)
    }

    constructor(any: Any) {
        val stringFromAny = any.toString()
        mChars = Array(stringFromAny.length) { stringFromAny[it] }
    }

    constructor(myString: MyString) {
        this.mChars = myString.mChars
    }

    constructor(myString: String) {
        this.mChars = Array(myString.length) { myString[it] }
    }

    fun getLength() = mChars.size

    fun getStringData() = mChars

    fun subString(start: Int, length: Int): MyString {
        var newArrayLength = length
        if (length > mChars.size - start) {
            newArrayLength = mChars.size - start
        }
        return MyString(Array(newArrayLength) { mChars[it + start] })
    }

    fun clear() {
        mChars = arrayOf()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        mChars.forEach { builder.append(it) }
        return builder.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MyString

        if (!Arrays.equals(mChars, other.mChars)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(mChars)
    }

    operator fun compareTo(myString2: MyString) = mChars.toString().compareTo(myString2.toString())

    override fun iterator(): Iterator<Char> = MyStringIterator(-1)

    private inner class MyStringIterator(
            private var cursor: Int
    ) : ListIterator<Char> {

        override fun hasPrevious() = cursor > 0

        override fun nextIndex() = cursor + 1

        override fun previous(): Char {
            cursor--
            return mChars[cursor]
        }

        override fun previousIndex() = cursor - 1

        override fun hasNext() = cursor < mChars.lastIndex

        override fun next(): Char {
            cursor++
            return mChars[cursor]
        }

    }

}