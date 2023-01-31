// camel-k: language=java property=file:application.properties

import org.apache.camel.builder.RouteBuilder;

public class KconsumerB extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    log.info("About to start route: Timer -> Kafka ");
    from("kafka:pm-data?brokers={{kafka.bootstrap.address}}")
        .log("Message received => ${body}");
  }
}
