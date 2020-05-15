package com.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName JumpPage
 * @Description TODO
 * @Author wk
 * @Date 2020/5/14 0014 09:33
 * @Version 1.0
 */
@Controller
public class JumpPageContorller {

    /**
     * 功能描述: 
     * @param: 公共跳转方法
     * @return: java.lang.String
     * @auther: wk
     * @date: 2020/5/15 0015 15:12
     */
    @GetMapping(value = "jumpPage")
    public String jumpPage(HttpServletRequest request, Model map){
        map.addAllAttributes(getParameterMap(request));
        String viewpage = request.getParameter("vewpate");
        return viewpage;
    }

    /**
     * 功能描述: 
     * @param: 输出map信息
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: wk
     * @date: 2020/5/15 0015 15:13
     */
    public static Map<String,Object> getParameterMap(HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        Map<String,String[]> paramMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entrys = paramMap.entrySet();
        if(null!=paramMap){
            for (Map.Entry<String, String[]> entry: entrys) {
                String key = entry.getKey();
                String[] value = entry.getValue();
                if(!StringUtils.isEmpty(key) && null!=value && value.length>0){
                    resultMap.put(key,value[0]);
                }
            }
        }
        return resultMap;
    }



}
