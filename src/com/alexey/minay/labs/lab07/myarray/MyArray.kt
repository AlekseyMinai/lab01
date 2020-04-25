package com.alexey.minay.labs.lab07.myarray

class MyArray<T>(var capacity: Int = DEFAULT_CAPACITY) {

    private var mContainer: Array<Any?> = Array(capacity) { null }
    private var mLastIndex = -1

    constructor(myArray: MyArray<T>) : this() {
        mContainer = Array(myArray.size()) { myArray[it] }
    }

    fun add(element: T) {
        if (capacity < mLastIndex) {
            resize(capacity + CAPACITY_DIFF)
        }
        mLastIndex++
        mContainer[mLastIndex] = element
    }

    fun size() = mLastIndex + 1

    operator fun get(index: Int): T {
        if (index > mLastIndex) {
            throw IndexOutOfBoundsException()
        }
        return mContainer[index] as T
    }

    fun resize(newCapacity: Int) {
        val newContainer = Array(newCapacity) { if (it < mContainer.size) mContainer[it] else null }
        mContainer = newContainer
        capacity = newCapacity
    }

    fun clear() {
        capacity = DEFAULT_CAPACITY
        mContainer = Array(capacity) { null }
        mLastIndex = -1
    }

    fun begin() = MyArrayIterator(-1)

    fun end() = MyArrayIterator(mLastIndex)

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        mContainer.forEachIndexed { index, value -> if (index <= mLastIndex) stringBuilder.append("$value ") }
        return stringBuilder.toString()
    }

    inner class MyArrayIterator(
            private var cursor: Int
    ) : MutableListIterator<T> {

        override fun hasPrevious() = cursor >= 0

        override fun previous(): T {
            if (!hasPrevious()) {
                throw NoSuchElementException()
            }
            return mContainer[cursor--] as T
        }

        override fun previousIndex() = cursor - 1

        override fun add(element: T) {
            if (mLastIndex >= capacity - 1) {
                val newCapacity = capacity + CAPACITY_DIFF
                val newContainer = Array(newCapacity) {
                    when {
                        it < cursor -> mContainer[it]
                        it == cursor -> element
                        it > cursor -> if (it <= mLastIndex + 1) mContainer[it - 1] else null
                        else -> null
                    }
                }
                mContainer = newContainer
                mLastIndex++
                return
            }
            for (i in mLastIndex downTo cursor) {
                mContainer[i + 1] = mContainer[i]
            }
            mContainer[cursor] = element
            mLastIndex++
        }

        override fun hasNext() = nextIndex() <= mLastIndex

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            return mContainer[++cursor] as T
        }

        override fun nextIndex() = cursor + 1

        override fun remove() {
            for (i in mLastIndex downTo cursor) {
                mContainer[i - 1] = mContainer[i]
            }
            mLastIndex--
        }

        override fun set(element: T) {
            mContainer[cursor] = element
        }

    }

    companion object {

        private const val DEFAULT_CAPACITY = 10
        private const val CAPACITY_DIFF = 10

    }


}