package com.guofy.elasticsearch.controller;

import com.guofy.elasticsearch.entity.Shinobi;
import com.guofy.elasticsearch.repository.ShinobiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:ElasticController.java</p >
 * <p>Description: </p >
 * <p>Copyright:</p >
 * <p>Date:2021/5/5 15:23</p >
 *
 * @author guofy
 * @version 1.0
 */
@RestController
@Slf4j
public class ElasticController {
    @Resource
    private ElasticsearchRestTemplate esTemplate;

    @Resource
    private ShinobiRepository repository;
    /**
     * 创建索引
     * @return
     */
    @GetMapping("/create")
    public String contextLoads(){
        IndexOperations indexOperations = esTemplate.indexOps(Shinobi.class);
        Document document = indexOperations.createMapping();
        return indexOperations.putMapping(document) ? "创建索引成功" : "创建索引失败";
    }

    /**
     * 创建文档
     * @param shinobi
     * @return
     */
    @PostMapping("/add")
    public String add(@RequestBody Shinobi shinobi){
        try {
            Shinobi shinobi1 = repository.save(shinobi);
            return shinobi1.getName() + "新增成功";
        }catch (Exception e){
            log.error("新增索引是'shinobi'的文档创建失败-->",e);
            return "新增失败";
        }
    }

    /**
     * 批量创建文档
     * @param shinobiList
     * @return
     */
    @PostMapping("/addList")
    public String addList(@RequestBody List<Shinobi> shinobiList){
        try {
            Iterable<Shinobi> list = repository.saveAll(shinobiList);
            return "shinobis新增成功";
        }catch (Exception e){
            log.error("新增索引是'shinobi'的文档列表创建失败-->",e);
            return "新增失败";
        }
    }

    /**
     * 查询分页
     * @param params
     * @return
     */
    @PostMapping("/findPage")
    public Page<Shinobi> findPage(@RequestBody Map<String,Object> params){
        int page = Integer.parseInt(params.get("page").toString());
        int size = Integer.parseInt(params.get("size").toString());
        Pageable pageable = PageRequest.of(page,size);
        return repository.findPage(pageable);
    }

    /**
     * 关键字高亮
     * @param name
     * @param jinada
     * @return
     */
    @GetMapping("/findByNameAndJinada/{name}/{jinada}")
    public List<SearchHit<Shinobi>> findByNameAndJinada(@PathVariable("name")String name,
                                                        @PathVariable("jinada") String jinada)
    {
        return repository.findByNameAndJinada(name,jinada);
    }
}
