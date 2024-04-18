package co.com.mq.usecase.procesarmensaje;

import co.com.mq.model.message.gateways.MensajeQueuePort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProcesarMensajeUseCase {

    private final MensajeQueuePort mensajeQueuePort;

    public Mono<Void> procesar(String mensaje) {
        // Lógica para procesar el mensaje
        return mensajeQueuePort.enviarMensaje(mensaje);
    }
}
