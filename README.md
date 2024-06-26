# Json Lib

Welcome to the Json-Lib, a library designed to streamline JSON serialization and deserialization in your projects.

## Usage

### Serialization to JSON

    val id = UUID.randomUUID()
    val payload = ExamplePayload(id, "name")

    val json = Json.toJson(payload)

    val expected = """{"id":"$id","name":"name","age":23}"""
    json shouldBe expected

### Serialization to JSON with pretty print

    val id = UUID.randomUUID()
    val payload = ExamplePayload(id, "name")

    val json = Json.toJsonWithPrettyPrint(payload)

    val expected = """{
              "id" : "$id",
              "name" : "name",
              "age" : 23
            }
        """.trimIndent()
    json shouldBe expected

### Deserialization from JSON

    val id = UUID.randomUUID()
    val json = """{"id":"$id","name":"name","age":23}"""

    val payload = Json.fromJson<ExamplePayload>(json)

    payload.id shouldBe id
    payload.name shouldBe "name"
    payload.age shouldBe 23
