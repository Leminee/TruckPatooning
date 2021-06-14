package project.truckplatooning.platoon;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Profile("send")
public class Publisher {

    public static Logger logger = LoggerFactory.getLogger(Publisher.class);

    private static String QUEUE_NAME = "TruckMessage";

    public static void main(String[] args) throws IOException, TimeoutException {

        System.out.println("PID: " + ProcessHandle.current().pid());

        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "LKW mit der PID 1343 hat den Platoon verlassen";

        channel.basicPublish("", QUEUE_NAME, null,message.getBytes("UTF-8"));
        logger.info("Nachricht gesendet!");


    }
}
