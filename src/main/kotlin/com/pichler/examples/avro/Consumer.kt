package com.pichler.examples.avro

import org.apache.avro.file.DataFileReader
import org.apache.avro.generic.GenericRecord
import org.apache.avro.io.DatumReader
import org.apache.avro.io.DecoderFactory
import org.apache.avro.io.EncoderFactory
import org.apache.avro.specific.SpecificDatumReader
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.io.DataInputStream
import java.io.InputStream
import java.util.*

@Component
class Consumer {

    @Scheduled(fixedRate = 600)
    fun consumer1()  {
        readFrom()
    }

    @Scheduled(fixedRate = 700)
    fun consumer2()  {
        readFrom()
    }

    private fun readFrom() {
        val first = Queue.readFirst()
        if (!first.isEmpty) {
            val byteInputStream = first.get().byteInputStream()
            val dataInputStream = DataInputStream(byteInputStream);
            // Deserialize
            val reader = SpecificDatumReader(MyCustomObject::class.java);
            var decoder = DecoderFactory.get().binaryDecoder(byteInputStream, null)
            val myCustomObject = reader.read(null, decoder);
            println(myCustomObject)
        } else {
            println("Nothing found!")
        }
    }
}