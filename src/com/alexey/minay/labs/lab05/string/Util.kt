package com.alexey.minay.labs.lab05.string

operator fun MyString.plus(myString: MyString) = MyString(getStringData() + myString.getStringData())

operator fun MyString.plus(string: String) = MyString(this.toString() + string)

operator fun Char.plus(myString: MyString) = MyString(addCharToStart(myString, this))

operator fun MyString.plus(char: Char) = MyString(addCharToEnd(this, char))

operator fun MyString.get(position: Int) = getStringData()[position]

operator fun MyString.set(position: Int, value: Char) {
    getStringData()[position] = value
}

fun addCharToStart(myString: MyString, char: Char) =
        Array(myString.getLength() + 1) {
            if (it == 0) char
            else myString.getStringData()[it - 1]
        }


fun addCharToEnd(myString: MyString, char: Char) =
        Array(myString.getLength() + 1) {
            if (it == myString.getLength()) char
            else myString.getStringData()[it]
        }


