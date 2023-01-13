package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqader.ktransport.example.models.Response
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

class ResponseTest {

    @Test
    fun testSerialization() {
        val response = Response("Hello World")
        val json = Json.encodeToString(response)
        val deserializedResponse = Json.decodeFromString(Response.serializer(), json)
        assertEquals(response, deserializedResponse)
    }

    @Test
    fun testDeserialization() {
        val json = """{"message": "Hello World"}"""
        val response = Json.decodeFromString(Response.serializer(), json)
        assertEquals("Hello World", response.message)
    }

    @Test
    fun testEquality() {
        val response1 = Response("Hello World")
        val response2 = Response("Hello World")
        val response3 = Response("Goodbye World")
        assertEquals(response1, response2)
        assertNotEquals(response1, response3)
    }
}