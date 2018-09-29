package com.king.kinghand.mianhuatang.service;

import com.king.kinghand.mianhuatang.dao.ExpressMapper;
import com.king.kinghand.mianhuatang.dao.UuserMapper;
import com.king.kinghand.mianhuatang.model.Express;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: king-hand
 * @description: 想法
 * @author: mianhuatang
 * @create: 2018-09-29 13:54
 **/
@Service
@Transactional(readOnly = true)
public class ExpressService {

    @Resource
    private ExpressMapper expressMapper;


    /**
     * 新增
     * @param thought
     * @return
     */
    public Express add(String thought){
        Express express = new Express();
        express.setCreateTime(new Date());
        express.setResult(thought);
        expressMapper.insert(express);
        return express;
    }

}
