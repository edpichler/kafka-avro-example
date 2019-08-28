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
    fun todo()  {
//        val writer = SpecificDatumWriter(MyCustomObject::class.java)
//        var data = ByteArray(0)
//        val stream = ByteArrayOutputStream()
//        var jsonEncoder: Encoder? = null
//        try {
//            jsonEncoder = EncoderFactory.get().jsonEncoder(
//                    AvroHttpRequest.getClassSchema(), stream)
//            writer.write(request, jsonEncoder)
//            jsonEncoder!!.flush()
//            data = stream.toByteArray()
//        } catch (e: IOException) {
//            logger.error("Serialization error:" + e.message)
//        }
//
//        return data
        println("oi")
    }
}