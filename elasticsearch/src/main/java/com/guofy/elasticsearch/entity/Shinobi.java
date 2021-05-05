package com.guofy.elasticsearch.entity;

import io.searchbox.annotations.JestId;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>Title:Article.java</p >
 * <p>Description: </p >
 * <p>Copyright: </p >
 * <p>Date:2021/5/4 19:27</p >
 *
 * @author guofy
 * @version 1.0
 */
@Data
@Document(indexName = "shinobi")
public class Shinobi {
    @Id
    private Integer id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Long)
    private Long age;
    @Field(type = FieldType.Text)
    private String jinada;

}
