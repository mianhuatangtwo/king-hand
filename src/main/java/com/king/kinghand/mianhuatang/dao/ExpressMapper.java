package com.king.kinghand.mianhuatang.dao;

import com.king.kinghand.mianhuatang.model.Express;
import com.king.kinghand.mianhuatang.model.ExpressExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpressMapper {
    long countByExample(ExpressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Express record);

    int insertSelective(Express record);

    Express selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Express record);

    int updateByPrimaryKey(Express record);
}