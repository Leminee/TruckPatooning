package project.truckplatooning.communication;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Profile("receive")
public class Receiver {

    public static Logger logger = LoggerFactory.getLogger(Publisher.class);

    private static String QUEUE_NAME = "TruckMessage";

    public static void main(String[] args) throws IOException, TimeoutException {

        System.out.println("PID: " + ProcessHandle.current().pid());

        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        channel.basicConsume(QUEUE_NAME, true, (consumerTag, message) -> {
            String m = new String(message.getBody(), "UTF-8");
            System.out.println("Nachricht erhalten: " + m);

        }, consumerTag -> {});



    }
}
