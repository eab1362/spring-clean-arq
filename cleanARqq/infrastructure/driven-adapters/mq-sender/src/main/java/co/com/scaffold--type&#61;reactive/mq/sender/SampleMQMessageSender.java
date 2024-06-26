package co.com.scaffold--type&amp;#61;reactive.mq.sender;

import co.com.bancolombia.commons.jms.api.MQMessageSender;
import co.com.bancolombia.commons.jms.mq.EnableMQMessageSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import jakarta.jms.Message;

@Component
@AllArgsConstructor
@EnableMQMessageSender
//@EnableMQSelectorMessageListener // Enable it to retrieve a specific message by correlationId
public class SampleMQMessageSender /* implements SomeGateway */ {
    private final MQMessageSender sender;
//    private final MQQueuesContainer container; // Inject it to reference a queue
//    private final MQMessageSelectorListener listener; // Inject it to retrieve a specific message by correlationId

    public Mono<String> send(String message) {
        return sender.send(context -> {
                    Message textMessage = context.createTextMessage(message);
//            textMessage.setJMSReplyTo(container.get("any-custom-value")); // Inject the reply to queue from container
                    return textMessage;
                })
                .name("mq_send_message")
                .tag("operation", "my-operation") // TODO: Change operation name
                .metrics();
    }

    // Enable it to retrieve a specific message by correlationId
//    public Mono<String> getResult(String correlationId) {
//        return listener.getMessage(correlationId)
//                .name("mq_receive_message")
//                .tag("operation", "my-operation") // TODO: Change operation name
//                .metrics()
//                .map(this::extractResponse);
//    }
//
//    private String extractResponse(Message message) {
//        TextMessage textMessage = (TextMessage) message;
//        return textMessage.getText();
//    }
}
