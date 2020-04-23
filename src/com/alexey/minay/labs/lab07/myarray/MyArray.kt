package com.alexey.minay.labs.lab07.myarray

class MyArray<T>(val capacity: Int = 10) {

    private var mContainer: Array<Any?> = Array(capacity) { null }
    //val s: ArrayList

    constructor(myArray: MyArray<T>) : this() {
        mContainer = Array(myArray.size()) { myArray[it] }
    }

    fun add(element: T) {

    }

    fun size() = mContainer.size

    operator fun get(index: Int): T {
        TODO()
    }

    fun resize(capacity: Int){

    }

    fun clear() {
        mContainer = Array(capacity) { null }
    }

    fun begin(): Iterator<T>{
        TODO()
    }

    fun end(): Iterator<T>{
        TODO()
    }

    fun rBegin(): Iterator<T>{
        TODO()
    }

    fun rEnd(): Iterator<T>{
        TODO()
    }

    inner class MyArrayIterator: MutableListIterator<T>{

        override fun hasPrevious(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun nextIndex(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun previous(): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun previousIndex(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun add(element: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun hasNext(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun next(): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun remove() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun set(element: T) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }


}