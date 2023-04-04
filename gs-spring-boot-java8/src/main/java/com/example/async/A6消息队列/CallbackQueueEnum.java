package com.example.async.A6消息队列;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

/**
 * CallbackQueueEnum
 *
 * @author TomLuo
 * @date 2023年03月22日 23:25
 */
public enum CallbackQueueEnum {
    ;
    public static RabbitProperties.Template QUEUE_GENSEE_CALLBACK;
}
