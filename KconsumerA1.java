// camel-k: language=java property=file:application.properties
// camel-k: dependency=camel:jackson
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class KconsumerA1 extends RouteBuilder {

  public static class Message { 
    private String id; 
    private int number; 
    private String string; 

    public Message() {
      super();
    }

    public Message(String id, int number, String string) { 
        this.id = id; 
        this.number = number;
        this.string = string;
    } 

    public String getId() { 
        return this.id; 
    } 

    public void setId(String id) { 
        this.id = id; 
    } 

    public int getNumber() { 
        return this.number; 
    } 

    public void setNumber(int number) { 
        this.number = number; 
    } 

    public String getString() { 
        return this.string; 
    } 

    public void setString(String string) { 
        this.string = string; 
    } 

    public String toString() { 
        return this.id; 
    } 
  }

  @Override
  public void configure() throws Exception {
    log.info("About to start route: Timer -> Kafka ");
    from("kafka:subscribers-a?brokers={{kafka.bootstrap.address}}")
        .unmarshal().json(JsonLibrary.Jackson, Message.class)
        .process(exchange -> {
          Message message = exchange.getMessage().getBody(Message.class);

          message.string = message.string.toLowerCase();

          exchange.getMessage().setBody(message);
        })
        .marshal().json()
        /*
        .unmarshal().json()
        .transform(simple("${body[id]}"))
         */
        .log("Message received => ${body}");
  }
}
