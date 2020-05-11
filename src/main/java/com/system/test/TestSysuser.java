package com.system.test;

import com.system.bean.Sysuser;
import com.system.service.ISysuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestSysuser
 * @Description TODO
 * @Author wk
 * @Date 2020/5/9 0009 16:18
 * @Version 1.0
 */
@RestController
public class TestSysuser {
    @Autowired
     ISysuserService iSysuserService;
    @GetMapping(value = "/sj/{username}")
    public  String sj(@PathVariable("username") String username){
        try {
            Sysuser sysuser = iSysuserService.querySysuser(username);
            return sysuser.getPassword();
        } catch (Exception e) {
            e.printStackTrace();
            return  "111";
        }

    }


}
