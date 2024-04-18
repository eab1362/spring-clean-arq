package co.com.mq.model.message.gateways;

import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public interface MensajeQueuePort {
    Mono<Void> enviarMensaje(String mensaje);
   // void recibirMensaje(Consumer<String> procesadorMensaje);
}
