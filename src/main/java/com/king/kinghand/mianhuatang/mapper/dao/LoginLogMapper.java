package com.king.kinghand.mianhuatang.mapper.dao;

import com.king.kinghand.mianhuatang.model.LoginLog;
import com.king.kinghand.mianhuatang.model.LoginLogExample;

public interface LoginLogMapper {
    long countByExample(LoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}