package com.guofy.rabbitmq.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title:MyAmqpConfig.java</p >
 * <p>Description: </p >
 * <p>Copyright:</p >
 * <p>Date:2021/4/30 15:47</p >
 *
 * @author guofy
 * @version 1.0
 */
@Configuration
public class MyAmqpConfig {
    /**
     * 配置 MessageConverter 让发送消息的对象转换成json格式
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
