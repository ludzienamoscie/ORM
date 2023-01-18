import org.junit.jupiter.api.Test;

public class ConsumerTest {
    @Test
    void consumerTest(){
        TicketConsumer ticketConsumer = new TicketConsumer();
        ticketConsumer.consume();
    }

    @Test
    void consumerTwoTest(){
        TicketConsumer ticketConsumer = new TicketConsumer();
        ticketConsumer.consume();
    }

}