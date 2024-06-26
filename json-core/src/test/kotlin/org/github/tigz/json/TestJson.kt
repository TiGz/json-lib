package org.github.tigz.json

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.github.tigz.json.Json
import java.util.UUID

class TestJson : ShouldSpec({

    context("Test Json") {
        should("toJson test") {

            val id = UUID.randomUUID()
            val payload = ExamplePayload(id, "name")

            val json = Json.toJson(payload)

            val expected = """{"id":"$id","name":"name","age":23}"""
            json shouldBe expected
        }



        should("fromJson test") {
            val id = UUID.randomUUID()
            val json = """{"id":"$id","name":"name","age":23}"""

            val payload = Json.fromJson<ExamplePayload>(json)

            payload.id shouldBe id
            payload.name shouldBe "name"
            payload.age shouldBe 23
        }
    }

    should("toJson test with pretty print") {

        val id = UUID.randomUUID()
        val payload = ExamplePayload(id, "name")

        val json = Json.toJsonWithPrettyPrint(payload)

        val expected = """
            {
              "id" : "$id",
              "name" : "name",
              "age" : 23
            }
        """.trimIndent()
        json shouldBe expected
    }

})

data class ExamplePayload(val id: UUID, val name: String, val age: Int = 23)
