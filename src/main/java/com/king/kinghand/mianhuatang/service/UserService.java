package com.king.kinghand.mianhuatang.service;

import com.king.kinghand.mianhuatang.dao.UuserMapper;
import com.king.kinghand.mianhuatang.model.Uuser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: king-hand
 * @description: 登录服务类
 * @author: mianhuatang
 * @create: 2018-09-04 15:58
 **/
@Service
@Transactional(readOnly = true)
public class UserService {

    @Resource
    private UuserMapper uuserMapper;

    /**
     *
     * @param userName
     * @return
     */
    public boolean isexits(String userName){
        int count = uuserMapper.findByUsername(userName);
        if(count > 0){
            return false;
        }
        return true;
    }

    /**
     *
     * @param uuser
     */
    @Transactional
    public void add(Uuser uuser){
        uuserMapper.insert(uuser);
    }

}
