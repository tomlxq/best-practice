package com.tom.example1.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年04月22日 17:59
 */



@Configuration
@ComponentScan("com.tom")
@EnableRedisRepositories(basePackages = "com.tom.example2.repo")
public class RedisConfig {
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        final JedisConnectionFactory conn = new JedisConnectionFactory();
        conn.setPassword("redis");
        conn.setHostName("192.168.238.150");
        return conn;
    }


    @Bean
    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

//    @Bean
//    MessageListenerAdapter messageListener() {
//        return new MessageListenerAdapter(new RedisMessageSubscriber());
//    }
//
//    @Bean
//    RedisMessageListenerContainer redisContainer() {
//        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(jedisConnectionFactory());
//        container.addMessageListener(messageListener(), topic());
//        return container;
//    }
//
//    @Bean
//    MessagePublisher redisPublisher() {
//        return new RedisMessagePublisher(redisTemplate(), topic());
//    }
//
//    @Bean
//    ChannelTopic topic() {
//        return new ChannelTopic("pubsub:queue");
//    }

}
