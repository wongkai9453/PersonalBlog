package com.system.controller;

import com.system.bean.Sysuser;
import com.system.service.ISysuserService;
import com.system.util.DatadefUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description 登陆页面
 * @Author wk
 * @Date 2020/5/8 0008 16:24
 * @Version 1.0
 */
@Controller
public class LoginController {
    @Autowired
    private ISysuserService iSysuserService;

    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @PostMapping(value = "user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,String> map,
                        HttpSession session){
        short landtype = loginVer(username, password,session);
        String landing = "未知错误";
        if(landtype==1){
            log.info("登陆成功");
            landing= "redirect:/main";
        }else if(landtype==0){
            map.put("msg","密码错误");
            landing= "login";
        }else if (landtype==-1){
            map.put("msg","未查询到用户");
            landing= "login";
        }else if (landtype==-2){
            map.put("msg","未输入密码");
            landing= "login";
        }else if (landtype==-3){
            map.put("msg","登陆报错");
            landing= "login";
        }
        return landing;
    }

    public short loginVer(String username ,String password,HttpSession session){

        if(!StringUtils.isEmpty(password) && !StringUtils.isEmpty(password)){
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            System.out.println(password);
        }else {
            return DatadefUtils.PD_NULL;//登陆未输入密码
        }
        try {
            Sysuser user = iSysuserService.querySysuser(username);
            if(user!=null){
                if(user.getPassword().equals(password)){//判断密码是否正确
                    session.setAttribute("userId",String.valueOf(user.getUserId()));
                    session.setAttribute("deptId",String.valueOf(user.getDeptId()));
                    session.setAttribute("loginName",user.getLoginName());
                    session.setAttribute("userName",user.getUserName());
                    return DatadefUtils.PD_YS;
                }else {
                    return DatadefUtils.PD_NO;
                }
            }else {
                return DatadefUtils.PD_ERROR;//为查询到用户
            }

        } catch (Exception e) {
//            e.printStackTrace();
            //   log.error(e.toString());
            return DatadefUtils.LOGIN;
        }
    }

}
