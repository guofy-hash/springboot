package com.guofy.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、配置连接工厂ConnectionFactory
 * 3、RabbitProperties 封装了 rabbitmq 的配置
 * 4、RabbitTemplate : 发送、接受消息工具
 * 5、AmqpAdmin : rabbitmq系统管理组件
 */

//开启基于注解的rabbitmq模式

@EnableRabbit
@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

}
