package com.alexey.minay.labs.lab02.template06

import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val text = "ararrab aba"
    val list2 = mutableListOf("arra", "arrab", "aba", "ra", "aa")
    val a2 = AhoCorasick2()
    a2.initWith(list2)
    a2.print()
    //a2.searchIn(text)
}

/*fun expandTemplate(template: String, params: Map<String, String>): String {

}*/


class AhoCorasick2 {

    private val root = Vertex(level = 0, parent = null)
    private val templates = mutableListOf<String>()

    class Vertex(val isLeaf: Boolean = false,
                 val level: Int,
                 var parent: Vertex?,
                 val parentKey: String = "",
                 val key: String = "",
                 val searchIndex: Int = -1
    ) {
        var suffixLink: Vertex? = null
        var child = mutableMapOf<String, Vertex>()

        override fun toString(): String {
            return "(level = $level, key = $key, sl = $suffixLink)"
        }
    }

    fun initWith(templates: List<String>) {
        this.templates.addAll(templates)
        for (i in templates.indices) {
            add(templates[i], i)
        }
        addSuffixLinks()
    }

    fun searchIn(text: String){
        var cursor = root
        text.forEach {
            var isResume = true
            while (isResume) {
                val nextVertex = cursor.child[it.toString()]
                if (nextVertex != null) {
                    if (nextVertex.isLeaf) {
                        cursor = nextVertex
                        println(templates[nextVertex.searchIndex])
                        isResume = false
                    } else {
                        cursor = nextVertex
                        isResume = false
                    }
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
        var parenKey = ""
        template.forEachIndexed { index, char ->
            if (vertex.child[char.toString()] == null) {
                val isLeaf = index == template.length - 1
                val newVertex = Vertex(
                        isLeaf = isLeaf,
                        level = vertex.level + 1,
                        parent = vertex,
                        parentKey = parenKey,
                        key = char.toString(),
                        searchIndex = if(isLeaf) searchIndex else -1
                )
                vertex.child[char.toString()] = newVertex
                vertex = newVertex
            } else {
                vertex = vertex.child[char.toString()]!!
            }
            parenKey = char.toString()
        }
    }

    private fun addSuffixLinks(){
        val vertex = root
        val queueVertex = LinkedBlockingQueue<Vertex>()
        val queueKey = LinkedBlockingQueue<String>()
        queueVertex.put(vertex)
        while (!queueVertex.isEmpty()) {
            val currentVertex = queueVertex.poll()
            val currentKey = queueKey.poll()
            currentVertex.child.forEach{
                queueVertex.put(it.value)
                queueKey.put(it.key)
            }
            when {
                currentVertex.level == 1 -> currentVertex.suffixLink = root
                currentVertex.level > 1 -> {
                    var cursor = currentVertex.parent
                    var isLookingForSuffixLink = true
                    while (isLookingForSuffixLink) {
                        val parentSuffixLink = cursor?.suffixLink
                        if (parentSuffixLink == null) {
                            isLookingForSuffixLink = false
                            if (root.child[currentKey] != null) {
                                currentVertex.suffixLink = root.child[currentKey]
                            }else{
                                currentVertex.suffixLink = root
                            }
                            continue
                        }
                        if (parentSuffixLink.child[currentKey] == null) {
                            cursor = parentSuffixLink.suffixLink
                            isLookingForSuffixLink = false
                        } else {
                            currentVertex.suffixLink = parentSuffixLink.child[currentKey]
                            isLookingForSuffixLink = false
                        }
                    }
                }
            }
        }
    }




}