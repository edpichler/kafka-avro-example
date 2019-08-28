package com.pichler.examples.avro

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.io.IOException
import org.apache.commons.compress.utils.IOUtils.toByteArray
import org.apache.avro.io.EncoderFactory
import java.io.ByteArrayOutputStream
import org.apache.avro.specific.SpecificDatumWriter
import org.apache.avro.io.DatumWriter
import org.apache.avro.io.Encoder


@Component
class Producer {

    @Scheduled(fixedRate = 1000)
    fun todo() {
        val writer = SpecificDatumWriter(MyCustomObject::class.java)
        val stream = ByteArrayOutputStream()
        var jsonEncoder: Encoder? = null
        jsonEncoder = EncoderFactory.get().jsonEncoder(
                MyCustomObject.getClassSchema(), stream)
        jsonEncoder!!.flush()

        Queue.add(stream.toString())
        println(stream.toString())
    }
}