package com.alexey.minay.labs.lab02.parser05

import org.junit.Test
import org.junit.Assert.*

class ApplicationKtTest {

    var protocol: Protocol? = null
    var port: Int? = null
    var host: String? = null
    var document: String? = null

    private val protocolRef: (Protocol) -> Unit = { protocol = it }
    private val portRef: (Int) -> Unit = { port = it }
    private val hostRef: (String) -> Unit = { host = it }
    private val documentRef: (String) -> Unit = { document = it }

    @Test
    fun shouldSetCorrectResult() {
        val url = "http://www.mysite.com/docs/document1.html?page=30&lang=en#title"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assert(result)
        assertEquals("www.mysite.com", host)
        assertEquals("docs/document1.html?page=30&lang=en#title", document)
        assertEquals(Protocol.HTTP, protocol)
        assertEquals(80, port)
    }

    @Test
    fun shouldSetEmptyDocument() {
        val url = "https://www.youtube.com"
        parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertEquals("", document)
    }

    @Test
    fun shouldNotHandleIncorrectPort1() {
        val url = "https://www.123.com:655366/doc"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertFalse(result)
    }

    @Test
    fun shouldNotHandleIncorrectPort2() {
        val url = "https://www.123.com:0/doc"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertFalse(result)
    }

}