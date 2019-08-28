package com.pichler.examples.avro

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.apache.avro.io.EncoderFactory
import java.io.ByteArrayOutputStream
import org.apache.avro.specific.SpecificDatumWriter


@Component
class Producer {

    var count = 0
    @Scheduled(fixedRate = 1000)
    fun publish() {

        val toSerialize = MyCustomObject.newBuilder().setName("my name").setDetails("Object number " + count++).build()

        val writer = SpecificDatumWriter(MyCustomObject::class.java)

        val outStream = ByteArrayOutputStream()
        var encoder = EncoderFactory.get().binaryEncoder(outStream, null)
        writer.write(toSerialize, encoder)
        encoder!!.flush()

        val serializedObject = outStream.toString()
        Queue.add(serializedObject)
    }
}