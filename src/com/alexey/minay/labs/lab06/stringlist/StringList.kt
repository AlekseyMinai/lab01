package com.alexey.minay.labs.lab06.stringlist

class StringList : MutableIterable<String> {

    private var mRoot: Node? = null
    private var mLast: Node? = null
    private var mNext: Node? = null

    private var mSize: Int = 0

    fun add(element: String) {
        if (mSize == 0) {
            mRoot = Node(element, null, null)
            mLast = mRoot
            mNext = mRoot
            mSize++
            return
        }
        mLast?.next = Node(element, null, mLast)
        mLast = mLast?.next
        mSize++
    }

    fun size() = mSize

    fun remove() {
        mLast?.previous?.next = null
        mLast = mLast?.previous
        mSize--
    }

    fun clear() {
        mRoot = null
        mLast = null
        mNext = null
        mSize = 0
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        forEach { stringBuilder.append("$it ") }
        return stringBuilder.toString()
    }

    override fun iterator() = StringListIterator()

    class Node(
            var value: String,
            var next: Node?,
            var previous: Node?
    )

    inner class StringListIterator : MutableListIterator<String> {

        private var mIndex: Int = 0
        private var mCursor: Node? = null

        override fun add(element: String) {
            val newNode = Node(element, mCursor, mCursor?.next)
            mCursor?.next = newNode
            newNode.next?.previous = newNode
        }

        override fun remove() {
            if(mCursor == null){
                mRoot = mRoot?.next
                mRoot?.previous = null
                mSize--
                return
            }
            mCursor = mCursor?.next
            mCursor?.previous?.next = mCursor?.next
            mCursor?.next?.previous = mCursor?.previous
            mCursor = mCursor?.next
            mSize--
        }

        override fun set(element: String) {
            mCursor?.value = element
        }

        override fun nextIndex() = mIndex

        override fun hasNext() = mIndex < mSize

        override fun next(): String {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            if (mCursor == null) {
                mCursor = mRoot
                mIndex = 0
                return mCursor?.value ?: ""
            }
            mCursor = if (mCursor == null) mCursor else mCursor?.next
            mIndex++
            return mCursor?.value ?: ""
        }

        override fun hasPrevious() = mIndex > 0

        override fun previous(): String {
            if (!hasPrevious()) {
                throw NoSuchElementException()
            }
            if (mCursor == null) {
                mCursor = mLast
                mIndex = mSize
                return mCursor?.value ?: ""
            }
            mCursor = if (mCursor == null) mCursor else mCursor?.previous
            mIndex--
            return mCursor?.value ?: ""
        }

        override fun previousIndex() = mIndex

    }

}