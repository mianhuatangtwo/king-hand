package com.king.kinghand.mianhuatang.controller;


import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: king-hand
 * @description: 登录
 * @author: mianhuatang
 * @create: 2018-04-03 13:12
 **/
@Controller
@Api(tags = "用户API")
public class LoginController {
	
	
	/**
	 * 跳转注册页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
		
		return "register/register";
	}

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "登录get请求",notes = "")
    @ApiImplicitParam(name = "name",value = "登录用户名", required = true,dataType = "String",defaultValue = "")
    public String login(Model model,String name){
        System.out.println("用户名：");
        return "login";
    }

    @RequestMapping(value = "/login/valid",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "校验登录post请求",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "登录用户名", required = true,dataType = "String",defaultValue = ""),
            @ApiImplicitParam(name = "pwd",value = "登录密码", required = true,dataType = "String",defaultValue = "")
        }
    )
    @ApiResponses({
            @ApiResponse(code = 100,message = "成功"),
            @ApiResponse(code = 101,message = "服务端错误")
    })
    public String save(Model model,String name,@RequestParam("pwd") String pwd){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("error_code","000000");
        obj.put("name",name);
        obj.put("pwd",pwd);
        return obj.toString();
    }
    

}
