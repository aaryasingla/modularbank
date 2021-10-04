package com.modular.bank.service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${modular.bank.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${modular.bank.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Object obj) {
		rabbitTemplate.convertAndSend(exchange, routingkey, obj);
	}
}
