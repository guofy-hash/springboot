package com.guofy.rabbitmq.service;

import com.guofy.rabbitmq.entity.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * <p>Title:BookService.java</p >
 * <p>Description: </p >
 * <p>Copyright:</p >
 * <p>Date:2021/4/30 16:47</p >
 *
 * @author guofy
 * @version 1.0
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息book = " + book);
    }

    @RabbitListener(queues = "atguigu.emps")
    public void receiveTwo(Message message){
        System.out.println("收到消息 message = " + message.getBody());
        System.out.println("收到消息 message = " + message.getMessageProperties());
    }

}
