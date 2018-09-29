package com.king.kinghand.common.utils;

/**
 * @program: king-hand
 * @description: 服务端返回代码
 * @author: mianhuatang
 * @create: 2018-09-04 15:33
 **/
public enum ResultCode {


    CODE_101("101","数据处理成功"),

    CODE_102("102","服务器异常"),

    CODE_2001("2001","验证码错误"),

    CODE_40001("40001","用户名已存在");

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public final String code;
    public final String message;



}
