package com.guofy.rabbitmq;

import com.guofy.rabbitmq.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 1、点对点
     */
    @Test
    void contextLoads() {
        //Message需要自己构造一个；定义一个消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message)

        //object只需要传入发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,message);
        Map<String,Object> map = new HashMap<>(16);
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld","点对点发送给atguigu.news队列"));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("火影忍者","岸本齐史"));
    }

    /**
     * 消息接收者
     */
    @Test
    void receive(){
        Object obj = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(obj.getClass());
        System.out.println(obj);
    }

    /**
     * 广播模式
     */
    @Test
    void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三体","刘慈欣"));
    }

    @Test
    void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("交换器创建成功");

        amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
        System.out.println("队列创建成功");

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,
                "amqpadmin.exchange","amqp.haha",null));
    }

}
