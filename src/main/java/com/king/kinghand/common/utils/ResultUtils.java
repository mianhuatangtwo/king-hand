package com.king.kinghand.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: king-hand
 * @description: 结果类工具
 * @author: mianhuatang
 * @create: 2018-09-04 15:31
 **/
public class ResultUtils {

    public static String convertSuccess(Object  obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultCode.CODE_101.code);
        map.put("message", ResultCode.CODE_101.message);
        map.put("result", obj);
        return GsonUtils.getGson().toJson(map);
    }

    public static String convertError(ResultCode code,Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code.code);
        map.put("message", code.message);
        map.put("result", obj);
        return GsonUtils.getGson().toJson(map);
    }



}
