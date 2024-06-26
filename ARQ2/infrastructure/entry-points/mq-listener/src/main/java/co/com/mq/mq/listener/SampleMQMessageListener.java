package co.com.mq.mq.listener;

import co.com.bancolombia.commons.jms.mq.MQListener;
import co.com.mq.usecase.procesarmensaje.ProcesarMensajeUseCase;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class SampleMQMessageListener {
    //private final Timer timer = Metrics.timer("mq_receive_message", "operation", "my-operation"); // TODO: Change operation name
    private final ProcesarMensajeUseCase procesarMensajeUseCase;

    // For fixed queues
    @MQListener
    public Mono<Void> process(Message message) throws JMSException {
      //  timer.record(System.currentTimeMillis() - message.getJMSTimestamp(), TimeUnit.MILLISECONDS);
        String text = ((TextMessage) message).getText();
         return procesarMensajeUseCase.procesar(text);
    }

    // For an automatic generated temporary queue
    // @MQListener(tempQueueAlias = "any-custom-value")
    // public Mono<Void> processFromTemporaryQueue(Message message) throws JMSException {
    //     timer.record(System.currentTimeMillis() - message.getJMSTimestamp(), TimeUnit.MILLISECONDS);
    //     String text = ((TextMessage) message).getText();
    //     // return useCase.sample(text);
    //     return Mono.empty();
    // }
}
