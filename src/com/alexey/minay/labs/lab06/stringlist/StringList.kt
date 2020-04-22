package com.alexey.minay.labs.lab06.stringlist

import java.util.*

class StringList : MutableIterable<String> {

    private var root: Node? = null
    private var last: Node? = null
    private var next: Node? = null

    private var size: Int = 0

    fun add(element: String) {
        if (size == 0) {
            root = Node(element, null, null)
            last = root
            next = root
            size++
            return
        }
        last?.next = Node(element, null, last)
        last = last?.next
        size++
    }

    fun size() = size

    fun remove() {
        next?.previous?.next = next?.next
        next?.next?.previous = next?.previous
        next = next?.next
        size--
    }

    fun clear() {
        root = null
        last = null
        next = null
        size = 0
    }

    fun set(position: Int, element: String) {
        val previous = next?.previous
        val nextCursor = next
        next = Node(element, nextCursor, next?.previous)
        previous?.next = next
        nextCursor?.previous = next
        size++
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        forEach { stringBuilder.append("$it, ") }
        return stringBuilder.toString()
    }

    override fun iterator() = StringListIterator(root)

    class Node(
            var value: String,
            var next: Node?,
            var previous: Node?
    )

    inner class StringListIterator(
            private var cursor: Node?
    ) : MutableListIterator<String> {

        private var index: Int = 0

        override fun add(element: String) {
            this@StringList.add(element)
        }

        override fun remove() {
            this@StringList.remove()
        }

        override fun set(element: String) {
            cursor?.value = element
        }

        override fun nextIndex() = index

        override fun hasNext() = index < size

        override fun next(): String {
            if (!hasNext()) {
                index = 0
                throw NoSuchElementException()
            }
            val value = cursor?.value ?: ""
            cursor = if (cursor?.next == null) cursor else cursor?.next
            index++
            return value
        }

        override fun hasPrevious() = index > 0

        override fun previous(): String {
            if (!hasPrevious()) {
                throw NoSuchElementException()
            }
            val value = cursor?.value ?: ""
            cursor = if (cursor?.previous == null) cursor else cursor?.previous
            index--
            return value
        }

        override fun previousIndex() = index - 1
    }

}