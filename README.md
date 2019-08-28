This is a SpringBoot application that publishes and consumes objects/events.

For serializing and deserializing it uses Apache Avro.

To publish and consume it uses kafka.

Main class is ```KafkaAvroExampleApplicationiy```.

The Avro kotlin/java objects are generated in compilation time by the ```generateAvroJava``` task of Gradle. To do that, it uses the schema contained on the folder ```src/main/avro/```. 
