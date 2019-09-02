package com.pichler.examples.kafka

import com.pichler.examples.avro.MyCustomObject
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.apache.avro.io.EncoderFactory
import java.io.ByteArrayOutputStream
import org.apache.avro.specific.SpecificDatumWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.HashMap
import org.springframework.kafka.core.ProducerFactory




@Component
class Producer {

    @Autowired
    private var kafkaTemplate: KafkaTemplate<String, String>? = null

    fun adjective() : String{
        val adjectives = arrayOf("Cool", "Nice", "Ugly", "Beautiful")
        return adjectives[(Math.random() * adjectives.size).toInt()]
    }

    var count = 0;
    @Scheduled(fixedRate = 1000)
    fun publish() {
        val toSerialize = MyCustomObject.newBuilder().setName("Name ${count++}").setDetails("${adjective()} details...").build()

        val writer = SpecificDatumWriter(MyCustomObject::class.java)

        val outStream = ByteArrayOutputStream()
        var encoder = EncoderFactory.get().binaryEncoder(outStream, null)
        writer.write(toSerialize, encoder)
        encoder!!.flush()

        val serializedObject = outStream.toString()
        kafkaTemplate!!.send("myTopic", serializedObject );
    }
}