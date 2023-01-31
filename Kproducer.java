// camel-k: language=java property=file:application.properties

import org.apache.camel.builder.RouteBuilder;

public class Kproducer extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    log.info("About to start route: Timer -> Kafka ");
    from("timer:foo")
        .routeId("FromTimer2Kafka")
        .setBody()
            .simple("{ \"id\": \"#${exchangeProperty.CamelTimerCounter}\", \"number\": 123, \"string\": \"ABC\" }")
        .to("kafka:producer-a?brokers={{kafka.bootstrap.address}}")
        .log("Message correctly sent to the topic!");
  }
}
