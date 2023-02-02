// camel-k: language=java property=file:application.properties

import org.apache.camel.builder.RouteBuilder;

public class RestProducer extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    rest("/")
        .post("/newoperation")
        .to("direct:foo");

    from("direct:foo")
        .routeId("FromTimer2Kafka")
        .to("kafka:producer-a?brokers={{kafka.bootstrap.address}}")
        .log("Message correctly sent to the topic!");
  }
}
