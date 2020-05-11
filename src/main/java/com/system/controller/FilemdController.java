package com.system.controller;

import com.system.bean.Filemd;
import com.system.service.IFilemdService;
import com.system.util.FileCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName FilemdController
 * @Description TODO
 * @Author wk
 * @Date 2020/5/11 0011 16:38
 * @Version 1.0
 */
@Controller
public class FilemdController {

    @Autowired
    private IFilemdService iFilemdService;

    @RequestMapping(value = "fileList")
    @ResponseBody
    public List<Filemd> fileList(Long userid){
        return iFilemdService.fileList(userid);
    }

    /**
     * 功能描述: 
     * @param: 跳转文本编辑器
     * @return: java.lang.String
     * @auther: wk
     * @date: 2020/5/11 0011 17:11
     */
    @GetMapping(value = "/editormd")
    public String editormd(){
        return "file/editormd";
    }

    @PostMapping(value = "/addFile")
    public String addFile(Filemd filemd){
        System.out.println(filemd.getFilecontent());
        String dates = String.valueOf(System.currentTimeMillis());//当前时间
        String namepath = "/"+filemd.getUserId()+"/"+dates+".md";//文件名
        String fileContent = filemd.getFilecontent();//文件内容

        String fileconten = filemd.getFilecontent().substring(0,50);
        filemd.setFilecontent(fileconten.replaceAll("[^\\u4e00-\\u9fa5]", "")); // 截取文件内容前五十个汉字
        filemd.setFileid(UUID.randomUUID().toString().replace("-", "").toLowerCase()); //生成uuId
        filemd.setFilepath(namepath);//文件路径
        filemd.setCreatetime(new Date());
        try {
            FileCreate.touchFile(namepath,fileContent);
            int ss = iFilemdService.insert(filemd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/main";
    }
}
