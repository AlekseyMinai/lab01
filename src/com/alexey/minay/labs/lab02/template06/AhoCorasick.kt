package com.alexey.minay.labs.lab02.template06

import java.util.concurrent.LinkedBlockingQueue


class AhoCorasick(
        private val entryList: List<Entry>,
        private val alphabet: List<Char>
) {
    private val alphabetSize: Int
        get() = 32
    private val vertexList = mutableListOf<Vertex>()
    private var vertexCount = 0

    fun solve(text: String) {
        vertexList.add(Vertex(alphabetSize))
        vertexList.add(Vertex(alphabetSize))
        vertexCount = 1
        for (entry in entryList) {
            addToTrie(entry)
        }

        var vertexCursor = 0
        for (char in text.toCharArray()) {
            vertexCursor = go(vertexCursor, charToIndex(char))
            val vertex = vertexList[vertexCursor]
            if (vertex.isLeaf) {
                val word = StringBuilder()
                var cursor = vertex
                do {
                    word.append(cursor.symbol)
                    cursor = vertexList[cursor.parent]
                } while (cursor.parent != -1)
                println(word.reverse())
            }
            vertexCursor = go(vertexCursor, charToIndex(char))
        }
    }

    private fun addToTrie(entry: Entry) {
        var vertexCursor = 0
        for (char in entry.value.toCharArray()) {
            val charIndex = charToIndex(char)
            if (vertexList[vertexCursor].next[charIndex] == -1) {
                val vertex = vertexList[vertexCount]
                vertex.suffixLink = -1
                vertex.parent = vertexCursor
                vertex.symbol = char
                vertex.charIndexFromParent = charIndex
                vertexList.add(Vertex(alphabetSize))
                vertexList[vertexCursor].next[charIndex] = vertexCount++
            }
            vertexCursor = vertexList[vertexCursor].next[charIndex]
        }
        vertexList[vertexCursor].isLeaf = true
    }

    private fun charToIndex(char: Char): Int {
        return char - 'a'
    }

    private fun go(vertexCursor: Int, charIndex: Int): Int {
        val vertex = vertexList[vertexCursor]
        if (vertex.go[charIndex] == -1) {
            if (vertex.next[charIndex] != -1) {
                vertex.go[charIndex] = vertex.next[charIndex]
            } else {
                vertex.go[charIndex] = if (vertexCursor == 0) 0 else go(goBySuffixLink(vertexCursor), charIndex)
            }
        }
        return vertex.go[charIndex]
    }

    private fun goBySuffixLink(vertexCursor: Int): Int {
        val vertex = vertexList[vertexCursor]
        if (vertex.suffixLink == -1) {
            if (vertexCursor == 0 || vertex.parent == 0) {
                vertex.suffixLink = 0
            } else {
                vertex.suffixLink = go(goBySuffixLink(vertex.parent), vertex.charIndexFromParent)
            }
        }
        return vertex.suffixLink
    }

    class Entry(val value: String)

    class Vertex(alphabetSize: Int) {
        val next = Array(alphabetSize) { -1 }
        var isLeaf = false
        var parent = -1
        var charIndexFromParent = -1
        var suffixLink = -1
        val go = Array(alphabetSize) { -1 }
        var symbol: Char = (-1).toChar()
    }
}

//private fun addSuffixLinks(/*vertex: Vertex = root*/) {
//    val vertex = root
//    val queue = LinkedBlockingQueue<AhoCorasick2.Vertex>()
//    queue.put(vertex)
//    while (!queue.isEmpty()) {
//        vertex.child.forEach {
//            queue.put(it.value)
//            val currentVertex = it.value
//            when {
//                currentVertex.level == 1 -> currentVertex.suffixLink = root
//                currentVertex.level > 1 -> {
//                    var cursor = it.value.parent
//                    var isLookingForSuffixLink = true
//                    while (isLookingForSuffixLink) {
//                        val parentSuffixLink = cursor?.suffixLink
//                        if (parentSuffixLink == null) {
//                            isLookingForSuffixLink = false
//                            it.value.suffixLink = root
//                            continue
//                        }
//                        if (parentSuffixLink.child[it.key] == null) {
//                            cursor = parentSuffixLink.suffixLink
//                        } else {
//                            it.value.suffixLink = parentSuffixLink.child[it.key]
//                            isLookingForSuffixLink = false
//                        }
//                    }
//                }
//            }
//            //addSuffixLinks(it.value)
//        }
//    }
//}

//    private fun addSuffixLinks(vertex: Vertex = root) {
//        vertex.child.forEach {
//            val currentVertex = it.value
//            when {
//                currentVertex.level == 1 -> currentVertex.suffixLink = root
//                currentVertex.level > 1 -> {
//                    var cursor = it.value.parent
//                    var isLookingForSuffixLink = true
//                    while (isLookingForSuffixLink) {
//                        val parentSuffixLink = cursor?.suffixLink
//                        if (parentSuffixLink == null) {
//                            isLookingForSuffixLink = false
//                            it.value.suffixLink = root
//                            continue
//                        }
//                        if (parentSuffixLink.child[it.key] == null) {
//                            cursor = parentSuffixLink.suffixLink
//                        } else {
//                            it.value.suffixLink = parentSuffixLink.child[it.key]
//                            isLookingForSuffixLink = false
//                        }
//                    }
//                }
//            }
//            addSuffixLinks(it.value)
//        }
//    }