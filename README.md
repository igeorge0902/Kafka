# Kafka
Using Kafka client to send and receive serialized objects

The SerializationClass.java class demonstrates how to serialize an object to make it possible to send through a tunnel created by Kafka. 
For example, after the object in the OutputStream is converted into an encoded string you can pass it through the tunnel, and then make the deserialization backwards. Borders of the procedures are marked with comments.
