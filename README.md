Demo projects with a service (producer) sending messages to another service (consumer).

Usage:
First, get a Kafka Docker instance launching a 
docker-compose up
in the main root directory.

Both services provide a Java-based configuration (it's also possible to use an application.properties instead).

In the producer service, we have two classes inside config package.
- KafkaTopics.java creates a new topic ("topic1") on the broker when launching application. This can also be done with command-line kafka-topics.sh process inside Kafka Docker instance.
- ProducerConfiguration.java provides essential configuration for sending messages from this service. Notice the broker port set before (9092) and the Json serializer, because we're sending a Json to the other service.
- The service sends a Json object through a Post Http request, exposed by the controller.

In the consumer service, we have just one configuration class.
- ConsumerConfiguration.java provides essential configuration for receiving messages from the producer service. Same broker port and a Json deserializer, this time. It's mandatory to set a group id, and to specify trusted packages (in this case, every package), to make conversion from Json to Java Class possible.
