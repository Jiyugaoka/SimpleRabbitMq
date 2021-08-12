package org.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue DirectQueue() {
        return new Queue("Direct_Queue",true);
    }

    @Bean
    public DirectExchange DirectExchange() {
        return new DirectExchange("Direct_Exchange", true, false);
    }

    @Bean
    public Binding bindingExchange() {
        return BindingBuilder.bind(DirectQueue()).to(DirectExchange()).with("Direct_Routing");
    }

}
