package com.pichler.examples.kafka

import com.pichler.examples.avro.MyCustomObject
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.SpecificDatumReader
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.io.DataInputStream
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload


@Component
class Consumer {

    private fun decodeAvro(data: String) : String{
        val byteInputStream = data.byteInputStream()
//        val dataInputStream = DataInputStream(byteInputStream);
        // Deserialize
        val reader = SpecificDatumReader(MyCustomObject::class.java);
        var decoder = DecoderFactory.get().binaryDecoder(byteInputStream, null)
        val myCustomObject = reader.read(null, decoder);

        return myCustomObject.toString()
    }

    @KafkaListener(topics = ["myTopic"], groupId = "myGroup")
    fun processMessage(@Payload content: String) {
        println("Read from Kafka: " + decodeAvro(content))
    }
}