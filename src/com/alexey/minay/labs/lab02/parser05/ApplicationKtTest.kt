package com.alexey.minay.labs.lab02.parser05

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

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
    fun shouldNotHandleIncorrectPortIfPortMoreThenAvailable() {
        val url = "https://www.123.com:655366/doc"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertFalse(result)
    }

    @Test
    fun shouldNotHandleIncorrectPortLessThenAvailable() {
        val url = "https://www.123.com:0/doc"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertFalse(result)
    }

    @Test
    fun shouldNotValidIncorrectProtocol() {
        val url = "smtp://www.123.com:32/doc"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertFalse(result)
    }

    @Test
    fun shouldNotHandleEmptyHost() {
        val url = "http:// /doc"
        val result = parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertFalse(result)
    }

    @Test
    fun shouldSetStandardPortForHttpsIfNotSpecified() {
        val url = "https://www.123.com/doc"
        parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertEquals(443, port)
    }

    @Test
    fun shouldSetStandardPortForHttpIfNotSpecified() {
        val url = "http://www.123.com/doc"
        parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertEquals(80, port)
    }

    @Test
    fun shouldSetStandardPortForFTPIfNotSpecified() {
        val url = "ftp://www.123.com/doc"
        parseUrl(url, protocolRef, portRef, hostRef, documentRef)
        assertEquals(21, port)
    }

}