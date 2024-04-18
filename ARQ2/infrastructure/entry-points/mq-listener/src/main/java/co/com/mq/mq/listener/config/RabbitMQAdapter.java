package co.com.mq.mq.listener.config;

import co.com.mq.model.message.gateways.MensajeQueuePort;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Component
public class RabbitMQAdapter implements MensajeQueuePort {

    private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE_NAME = "myExchange";
    private static final String ROUTING_KEY = "my.routing.key";


    @Autowired
    public RabbitMQAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Mono<Void> enviarMensaje(String mensaje) {
        // Cambia "nombreCola" por EXCHANGE_NAME y especifica la ROUTING_KEY
        return Mono.fromRunnable(() -> rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, mensaje)).then();
    }

    @RabbitListener(queues = "testQueue")
    public void recibirMensaje(String mensaje) {
        // El procesamiento del mensaje se mantiene igual
        procesarMensajeReactivamente(mensaje).subscribe();
    }

    @PostConstruct
    public void enviarMensajeTest() {
        // Ajusta para usar EXCHANGE_NAME y ROUTING_KEY al enviar el mensaje de prueba
        String mensaje = "Hola Mundo desde RabbitMQ!";
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, mensaje);
        System.out.println("Mensaje de prueba enviado a 'testQueue' mediante '" + EXCHANGE_NAME + "' con routingKey '" + ROUTING_KEY + "': " + mensaje);
    }

    private Mono<Void> procesarMensajeReactivamente(String mensaje) {
        // Lógica de procesamiento reactiva
        System.out.println("Mensaje recibido: " + mensaje);
        return Mono.empty(); // Asume que este es un procesamiento reactivo
    }
}