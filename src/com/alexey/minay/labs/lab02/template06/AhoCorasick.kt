package com.alexey.minay.labs.lab02.template06

import java.util.concurrent.LinkedBlockingQueue

class AhoCorasick {

    private val root = Vertex(level = 0, parent = null)
    private val templates = mutableListOf<String>()

    fun initWith(templates: List<String>) {
        this.templates.addAll(templates)
        for (i in templates.indices) {
            add(templates[i], i)
        }
        addSuffixLinks()
    }

    fun searchIn(text: String): List<Result> {
        var cursor = root
        val result = mutableListOf<Result>()
        text.forEachIndexed { index, char ->
            var isResume = true
            while (isResume) {
                val nextVertex = cursor.child[char.toString()]
                if (nextVertex != null) {
                    if (nextVertex.isLeaf) {
                        cursor = nextVertex
                        if (nextVertex.child.isEmpty()) {
                            cursor = root
                        }
                        result.add(Result(index, templates[nextVertex.searchIndex]))
                    } else {
                        cursor = nextVertex
                    }
                    isResume = false
                } else {
                    cursor = when {
                        cursor.suffixLink != null -> cursor.suffixLink!!
                        else -> {
                            isResume = false
                            root
                        }
                    }
                }
            }
        }
        return result
    }

    fun print() {
        val vertex = root
        val queue = LinkedBlockingQueue<Vertex>()
        queue.put(vertex)
        while (!queue.isEmpty()) {
            val nextVertex = queue.poll()
            println("$nextVertex")
            nextVertex.child.forEach {
                queue.put(it.value)
            }
        }
    }

    private fun add(template: String, searchIndex: Int) {
        var vertex = root
        template.forEachIndexed { index, char ->
            val nextVertex = vertex.child[char.toString()]
            if (nextVertex == null) {
                val isLeaf = index == template.length - 1
                val newVertex = Vertex(
                        isLeaf = isLeaf,
                        level = vertex.level + 1,
                        parent = vertex,
                        key = char.toString(),
                        searchIndex = if (isLeaf) searchIndex else -1
                )
                vertex.child[char.toString()] = newVertex
                vertex = newVertex
            } else {
                vertex = nextVertex
            }
        }
    }

    private fun addSuffixLinks() {
        val vertex = root
        val queueVertex = LinkedBlockingQueue<Vertex>()
        val queueKey = LinkedBlockingQueue<String>()
        queueVertex.put(vertex)
        while (!queueVertex.isEmpty()) {
            val currentVertex = queueVertex.poll()
            val currentKey = queueKey.poll()
            currentVertex.child.forEach {
                queueVertex.put(it.value)
                queueKey.put(it.key)
            }
            when {
                currentVertex.level == 1 -> currentVertex.suffixLink = root
                currentVertex.level > 1 -> addSuffixLink(currentVertex, currentKey)
            }
        }
    }

    private fun addSuffixLink(currentVertex: Vertex, currentKey: String) {
        var cursor = currentVertex.parent
        var isLookingForSuffixLink = true
        while (isLookingForSuffixLink) {
            val parentSuffixLink = cursor?.suffixLink
            if (parentSuffixLink == null) {
                val nextVertex = root.child[currentKey]
                isLookingForSuffixLink = false
                if (nextVertex != null) {
                    currentVertex.suffixLink = nextVertex
                } else {
                    currentVertex.suffixLink = root
                }
                continue
            }
            val suffixLinkVertex = parentSuffixLink.child[currentKey]
            if (suffixLinkVertex == null) {
                cursor = parentSuffixLink.suffixLink
            } else {
                currentVertex.suffixLink = suffixLinkVertex
            }
            isLookingForSuffixLink = false
        }
    }

    class Vertex(
            val isLeaf: Boolean = false,
            val level: Int,
            var parent: Vertex?,
            val key: String = "",
            val searchIndex: Int = -1
    ) {
        var suffixLink: Vertex? = null
        var child = mutableMapOf<String, Vertex>()

        override fun toString(): String {
            return "(level = $level, key = $key, sl = $suffixLink)"
        }

    }

}