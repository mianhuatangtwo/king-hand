package com.king.kinghand.mianhuatang.only;

import com.king.kinghand.common.utils.ResultUtils;
import com.king.kinghand.mianhuatang.model.Express;
import com.king.kinghand.mianhuatang.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: king-hand
 * @description: 唯一
 * @author: mianhuatang
 * @create: 2018-09-23 15:46
 **/
@Controller
@RequestMapping("/only")
public class OnlyController {

    @Autowired
    private ExpressService expressService;

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/llj",method = RequestMethod.GET)
    public String onlyView(HttpServletRequest request,Model model){

        return "only/llj";
    }

    /**
     * 告诉他
     * @param request
     * @param thought
     * @return
     */
    @RequestMapping(value = "/llj/result",method = RequestMethod.POST)
    @ResponseBody
    public String getResult(HttpServletRequest request,String thought){
        Express express = expressService.add(thought);
        return ResultUtils.convertSuccess("");
    }

}
