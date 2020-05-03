package com.alexey.minay.labs.lab05.string

fun main(args: Array<String>) {
    var s = MyString(arrayOf('s', 'a', 'w', 'd', 'w', 'q'))
    var d = MyString(arrayOf('s', 'a', 'w', 'd', 'w', 'q'))
    var t = MyString("asdas")
    var k = t.subString(2, 2)
    k[0] = 'e'
    val e = k[0]
    print(e)
}

operator fun MyString.plus(myString: MyString) = MyString(getStringData() + myString.getStringData())

operator fun MyString.plus(string: String) = MyString(this.toString() + string)

operator fun Char.plus(myString: MyString) = MyString(addCharToStart(myString, this))

operator fun MyString.plus(char: Char) = MyString(addCharToEnd(this, char))

operator fun MyString.get(position: Int) = getStringData()[position]

operator fun MyString.set(position: Int, value: Char){
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


