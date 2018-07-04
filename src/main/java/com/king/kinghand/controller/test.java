package com.king.kinghand.controller;

import ch.qos.logback.core.spi.LogbackLock;
import com.king.kinghand.config.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;


@Controller
public class test {

    private final static Logger logger = LoggerFactory.getLogger(test.class);

    @Value("${test.msg}")
    private String msg;
    @Autowired
    private Environment environment;
    @Autowired
    private Random random;
    @Value("${my.random.uuid}")
    private String uuid;

    @ResponseBody
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String test(@PathVariable("name") String name){
        StringBuilder sbf = new StringBuilder();
        System.out.println( msg+"====="+environment.getProperty("test.msg"));
        sbf.append(name).append(",").append(msg);
        return sbf.toString();
    }

    @RequestMapping(value = "/test/{userId}/register",method = RequestMethod.GET)
    public String testView(@PathVariable("userId") String userId, Model model){
        logger.info("[用户注册：]"+msg);
        model.addAttribute("random",random);
        model.addAttribute("userId",userId);
        model.addAttribute("uuid",uuid);
        model.addAttribute("msg",msg);
        return "test";
    }

}
