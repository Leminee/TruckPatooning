package project.truckplatooning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class TruckPlatooningApplication {

	public static Logger logger = LoggerFactory.getLogger(TruckPlatooningApplication.class);
	public static final String QUEUE = "Truck";
	public static final String EXCHANGE = "message_exchange";
	public static final String ROUTING_KEY = "message_routingKey";

	@Bean
	public Queue queue() {
		return  new Queue(QUEUE);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder
				.bind(queue)
				.to(exchange)
				.with(ROUTING_KEY);
	}
	@Bean
	public MessageConverter messageConverter() {
		return  new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return  template;
	}



	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		SpringApplication.run(TruckPlatooningApplication.class, args);

		System.out.println("PID: " + ProcessHandle.current().pid());

		String processToKill = sc.nextLine();
		String cmd = "kill -9 " + processToKill;
		Runtime.getRuntime().exec(cmd);
	}



}
