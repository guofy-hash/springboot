package com.guofy.rabbitmq.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>Title:Book.java</p >
 * <p>Description: </p >
 * <p>Copyright: Copyright(c)2018</p >
 * <p>Date:2021/4/30 16:36</p >
 *
 * @author guofy
 * @version 1.0
 */
@AllArgsConstructor
public class Book implements Serializable {
    public Book (){};
    @Getter
    @Setter
    private String bookName;
    @Getter
    @Setter
    private String author;

}
