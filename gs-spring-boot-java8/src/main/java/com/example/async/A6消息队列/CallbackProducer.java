//package com.example.async.A6消息队列;
//
//import com.fasterxml.jackson.databind.json.JsonMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * CallbackProducer
// *
// * @author TomLuo
// * @date 2023年03月22日 23:23
// */
//@Slf4j
//@Component
//public class CallbackProducer {
//
//    @Autowired
//    AmqpTemplate amqpTemplate;
//
//    public void sendCallbackMessage(CallbackDTO callbackDTO, final long delayTimes) {
//
//        log.info("生产者发送消息，callbackDTO，{}", callbackDTO);
//
//        amqpTemplate.convertAndSend(CallbackQueueEnum.QUEUE_GENSEE_CALLBACK.getExchange(), CallbackQueueEnum.QUEUE_GENSEE_CALLBACK.getRoutingKey(), JsonMapper.getInstance().toJson(genseeCallbackDTO), new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                //给消息设置延迟毫秒值，通过给消息设置x-delay头来设置消息从交换机发送到队列的延迟时间
//                message.getMessageProperties().setHeader("x-delay", delayTimes);
//                message.getMessageProperties().setCorrelationId(callbackDTO.getSdkId());
//                return message;
//            }
//        });
//    }
//}