//package com.example.async.A6消息队列;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * eee
// *
// * @author TomLuo
// * @date 2023年03月22日 23:27
// */
//@Slf4j
//@Component
//@RabbitListener(queues = "message.callback", containerFactory = "rabbitListenerContainerFactory")
//public class CallbackConsumer {
//
//    @Autowired
//    private IGlobalUserService globalUserService;
//
//    @RabbitHandler
//    public void handle(String json, Channel channel, @Headers Map<String, Object> map) throws Exception {
//
//        if (map.get("error") != null) {
//            //否认消息
//            channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, true);
//            return;
//        }
//
//        try {
//
//            CallbackDTO callbackDTO = JsonMapper.getInstance().fromJson(json, CallbackDTO.class);
//            //执行业务逻辑
//            globalUserService.execute(callbackDTO);
//            //消息消息成功手动确认，对应消息确认模式acknowledge-mode: manual
//            channel.basicAck((Long) map.get(AmqpHeaders.DELIVERY_TAG), false);
//
//        } catch (Exception e) {
//            log.error("回调失败 -> {}", e);
//        }
//    }
//}