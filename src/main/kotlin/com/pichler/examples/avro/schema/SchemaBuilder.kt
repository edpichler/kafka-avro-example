package com.pichler.examples.avro.schema

import org.apache.avro.SchemaBuilder
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Paths


/**
 * This class helps to create an schema.json schema.
 */
fun main(args: Array<String>) {
    val schemaName = "MyCustomObject"
    val clientIdentifier = SchemaBuilder.record(schemaName)
            .namespace("com.pichler.examples.avro.schema")
            .fields()
            .requiredString("hostName").requiredString("ipAddress")
            .endRecord()

    val fileName = Paths.get(".").normalize().toAbsolutePath().toString() + "/src/main/resources/avro/$schemaName.json"
    println(fileName)
    File(fileName).createNewFile()
    val writer = BufferedWriter(FileWriter(fileName))
    writer.write(clientIdentifier.toString())
    writer.close()
}
