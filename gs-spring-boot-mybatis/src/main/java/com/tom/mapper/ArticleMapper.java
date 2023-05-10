package com.tom.mapper;

import com.tom.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * aaa
 *
 * @author TomLuo
 * @date 2023年04月22日 6:34
 */
public interface ArticleMapper {
    @Select("SELECT * FROM ARTICLES WHERE id = #{id}")
    Article getArticle(@Param("id") Long id);
}