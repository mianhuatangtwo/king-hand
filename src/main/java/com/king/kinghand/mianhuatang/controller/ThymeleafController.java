package com.king.kinghand.mianhuatang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.king.kinghand.common.support.ControllerSupport;
import com.king.kinghand.mianhuatang.entity.Book;

/**
 * 
 * @author wx
 *
 */
@Controller
@RequestMapping("/thym")
public class ThymeleafController extends ControllerSupport{
	
	
	@RequestMapping("/test")
	public ModelAndView getMsg(ModelAndView model) {
		model.setViewName("myThymeleaf");
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			lists.add("Jake"+i);
		}
		model.addObject("lists", lists);
		
		Book book = new Book("盗墓笔记", "南派三叔", "10.50");
		model.addObject("book", book);
//		Users users = usersService.findById(10001L);
//		model.addObject("users", users);
		
		return model;
	}
	
	
	

}
