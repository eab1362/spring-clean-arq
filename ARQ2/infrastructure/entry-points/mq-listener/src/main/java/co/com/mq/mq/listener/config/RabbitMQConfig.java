package co.com.mq.mq.listener.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("testQueue", false);
    }

    @Bean
    public TopicExchange myExchange() {
        // Cambiado para devolver específicamente un TopicExchange
        return new TopicExchange("myExchange", true, false);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange myExchange) {
        // Asegúrate de que los parámetros del método coincidan con los nombres de los beans
        return BindingBuilder.bind(queue).to(myExchange).with("my.routing.key");
    }
}