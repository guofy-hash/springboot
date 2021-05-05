package com.guofy.elasticsearch.repository;

import com.guofy.elasticsearch.entity.Shinobi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * <p>Title:ElasticSearchRepository.java</p >
 * <p>Description: </p >
 * <p>Copyright: </p >
 * <p>Date:2021/5/5 15:31</p >
 *
 * @author guofy
 * @version 1.0
 */
public interface ShinobiRepository extends ElasticsearchRepository<Shinobi,Integer> {

    /**
     * 自定义查询分页
     * @param pageable
     * @return
     */
    @Query("{\n" +
            "    \"match_all\": {}\n" +
            "  }")
    Page<Shinobi> findPage(Pageable pageable);

    /**
     * 关键字高亮
     * @param name 名称
     * @param jinada 忍术
     * @return
     */
    @Highlight(fields = {
            @HighlightField(name = "name"),
            @HighlightField(name = "jinada")
    })
    List<SearchHit<Shinobi>> findByNameAndJinada(String name, String jinada);
}
