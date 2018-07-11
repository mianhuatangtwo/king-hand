package com.king.kinghand.mianhuatang.mapper.dao;

import com.king.kinghand.mianhuatang.model.Uuser;
import com.king.kinghand.mianhuatang.model.UuserExample;

public interface UuserMapper {
    long countByExample(UuserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Uuser record);

    int insertSelective(Uuser record);

    Uuser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Uuser record);

    int updateByPrimaryKey(Uuser record);
}