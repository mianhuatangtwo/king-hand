package com.king.kinghand.mianhuatang.controller;


import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.king.kinghand.common.utils.GsonUtils;
import com.king.kinghand.common.utils.ResultCode;
import com.king.kinghand.common.utils.ResultUtils;
import com.king.kinghand.mianhuatang.dao.UuserMapper;
import com.king.kinghand.mianhuatang.model.Uuser;
import com.king.kinghand.mianhuatang.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: king-hand
 * @description: 登录
 * @author: mianhuatang
 * @create: 2018-04-03 13:12
 **/
@Controller
@RequestMapping(value = "/login",produces = { "application/json;charset=utf-8"})
@Api(tags = "用户API")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private DefaultKaptcha captchaProducer;
	@Autowired
    private UserService userService;
    @Resource
    private UuserMapper uuserMapper;


    /**
	 * 跳转注册页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register(HttpServletRequest request,HttpServletResponse response) {
		
		return "register/register";
	}

    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String add(HttpServletRequest request,HttpServletResponse response,Uuser uuser) {
        if (uuser != null){
            userService.add(uuser);
        }
        return "login/login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(){

        return "login/login";
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

    /**
     * 用户名校验
     * @param request
     * @param response
     * @param userName
     * @return
     */
    @RequestMapping(value = "/valid/name",method = RequestMethod.GET)
    @ResponseBody
    public String validUserName(HttpServletRequest request,HttpServletResponse response,String userName){
        boolean isexists = userService.isexits(userName);
        if(!isexists){
            return ResultUtils.convertError(ResultCode.CODE_40001,"");
        }
        return ResultUtils.convertSuccess("");
    }

    /**
     *  生成验证码
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @ApiOperation(value = "获取验证码",notes = "生产验证码字符串")
    @RequestMapping(value = "/defaultKaptcha",method = RequestMethod.GET)
    public void defaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
    throws Exception{

        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try{
            //生产验证码字符串保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode",createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        }catch (Exception e) {
            logger.error("生成验证码字符串异常：" + e.getMessage(), e);
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control","no-store");
        httpServletResponse.setHeader("Pragma","no-cache");
        httpServletResponse.setDateHeader("Expires",0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();

    }

    /**
     * 校验验证码
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "校验验证码",notes = "校验验证码是否正确")
    @RequestMapping(value = "/valid/kaptcha",method = RequestMethod.GET)
    @ResponseBody
    public String validKaptcha(HttpServletRequest request,HttpServletResponse response,String vrifyCode) throws Exception{

        String captchaId = (String) request.getSession().getAttribute("vrifyCode");
        String parameter = URLDecoder.decode(vrifyCode,"utf-8");
        logger.info("Session vrifyCode " + captchaId + " form vrifyCode " + parameter);
        if(!captchaId.equals(parameter)){
            return ResultUtils.convertError(ResultCode.CODE_2001,"");
        }else{
            return ResultUtils.convertSuccess("");
        }
    }

}
