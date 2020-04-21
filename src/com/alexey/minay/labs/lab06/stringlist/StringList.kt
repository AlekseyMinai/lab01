package com.alexey.minay.labs.lab06.stringlist

import java.util.*

class StringList : MutableListIterator<String>, MutableIterable<String> {

    private var root: Node? = null
    private var last: Node? = null
    private var next: Node? = null
    private var lastReturned: Node? = null
    private var nextIndex = 0
    private var size: Int = 0

    override fun add(element: String) {
        lastReturned = null
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

    fun clear() {
        root = null
        last = null
        next = null
        size = 0
    }

    override fun hasNext() = nextIndex < size

    override fun next(): String {
        if (!hasNext()) {
            nextIndex = 0
            throw NoSuchElementException()
        }
        lastReturned = next
        val value = lastReturned?.value ?: ""
        nextIndex++
        next = next?.next

        return value
    }

    override fun hasPrevious() = nextIndex > 0

    override fun nextIndex() = nextIndex

    override fun previous(): String {
        if (!hasPrevious()) {
            throw IndexOutOfBoundsException()
        }
        lastReturned = if (next == null) last else next?.previous
        nextIndex--
        return lastReturned?.value ?: ""
    }

    override fun previousIndex() = nextIndex - 1

    class Node(
            var value: String,
            var next: Node?,
            var previous: Node?
    )

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        forEach { stringBuilder.append("$it, ") }
        return stringBuilder.toString()
    }

    override fun iterator(): MutableIterator<String> {
        next = root
        lastReturned = root
        nextIndex = 0
        return this
    }

    override fun remove() {
        next?.previous?.next = next?.next
        next?.next?.previous = next?.previous
        next = next?.next
        size--
    }

    override fun set(element: String) {
        lastReturned?.value = element
    }

//    override fun set(element: String) {
//        val previous = next?.previous
//        val nextCursor = next
//        next = Node(element, nextCursor, next?.previous)
//        previous?.next = next
//        nextCursor?.previous = next
//        size++
//    }

}