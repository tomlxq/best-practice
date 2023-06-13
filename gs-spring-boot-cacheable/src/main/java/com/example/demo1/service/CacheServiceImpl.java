package com.example.demo1.service;

import com.example.entities.MatchNewsVO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * CacheServiceImpl
 *
 * @author TomLuo
 * @date 2023年03月18日 1:49
 */
public class CacheServiceImpl {

    @Cacheable(value = "olympic_match_new_action", key = "'get_relate_news_'+#rsc")
    public List<MatchNewsVO> getRelateNews(String rsc) {
        //....
        return null;
    }
}