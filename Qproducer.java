// camel-k: language=java property=file:application.properties

import org.apache.camel.builder.RouteBuilder;

public class Qproducer extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    log.info("About to start route: Timer -> Kafka ");
    from("timer:foo")
        .routeId("FromTimer2Kafka")
        .setBody()
            .simple("Message #${exchangeProperty.CamelTimerCounter}")
	.to("jms://queue:alarms?connectionFactory=#ABC&timeToLive={{messaging.ttl.alarms}}")
        .log("Message correctly sent to the topic!");
  }
}
