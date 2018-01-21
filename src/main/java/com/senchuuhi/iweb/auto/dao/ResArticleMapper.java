package com.senchuuhi.iweb.auto.dao;

import com.senchuuhi.iweb.auto.entity.ResArticle;
import com.senchuuhi.iweb.auto.entity.ResArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    long countByExample(ResArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int deleteByExample(ResArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int insert(ResArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int insertSelective(ResArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    List<ResArticle> selectByExample(ResArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    ResArticle selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ResArticle record, @Param("example") ResArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ResArticle record, @Param("example") ResArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ResArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ResArticle record);
}