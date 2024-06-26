package co.com.scaffold--type&amp;#61;reactive.mq.reqreply;

import co.com.bancolombia.commons.jms.mq.ReqReply;
import reactor.core.publisher.Mono;

import jakarta.jms.Message;

@ReqReply(requestQueue = "DEV.QUEUE.1") // TODO: Change the queue name, or use from properties like ${my.queue}
public interface ReqReplyGateway {
    Mono<Message> requestReply(String message);
// You can use one of the next alternatives
//    Mono<Message> requestReply(String message, Duration timeout);
//
//    Mono<Message> requestReply(MQMessageCreator messageCreator);
//
//    Mono<Message> requestReply(MQMessageCreator messageCreator, Duration timeout);
}
