package com.system.controller;

import com.system.bean.Filemd;
import com.system.service.IFilemdService;
import com.system.util.FileCreate;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public List<Filemd> fileList(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userid = String.valueOf(session.getAttribute("userId"));
        return iFilemdService.fileList(Long.valueOf(userid));
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

    /**
     * 功能描述: 
     * @param: 发布博客
     * @return: java.lang.String
     * @auther: wk
     * @date: 2020/5/12 0012 11:56
     */
    @PostMapping(value = "/addFile")
    public String addFile(Filemd filemd){
        System.out.println(filemd.getFilecontent());
        String dates = String.valueOf(System.currentTimeMillis());//当前时间
        String namepath = "/"+filemd.getUserId()+"/"+dates+".md";//文件名
        String fileContent = filemd.getFilecontent();//文件内容
        String fileconten = "";
        if(fileContent.length()<50){
            fileconten = fileContent;
        }else {
            fileconten = filemd.getFilecontent().substring(0,50);
        }
        filemd.setFilecontent(fileconten.replaceAll("[^\\u4e00-\\u9fa5]", "")); // 截取文件内容前五十个汉字
        filemd.setFileid(UUID.randomUUID().toString().replace("-", "").toLowerCase()); //生成uuId
        filemd.setFilepath(namepath);//文件路径
        filemd.setCreatetime(new Date());
        try {
            boolean touchFile = FileCreate.touchFile(namepath,fileContent);
            if(touchFile==true){
                iFilemdService.insert(filemd);
            }

        } catch (IOException e) {
            FileCreate.deleteFile(namepath);
            e.printStackTrace();
        }
        return "redirect:/main";
    }

    /**
     * @Author wk
     * @Description: 显示数据信息
     * @Date 2020/5/17 9:28
     * @Param: [fileid]
     * @return: java.util.Map
     **/
    @RequestMapping(value = "/seachFile")
    @ResponseBody
    public Map seachFile(String fileid){
        Filemd filemd = new Filemd();
        Map<String,String> map = new HashMap<>();
        try {
            filemd = iFilemdService.queryFilemed(fileid);
            String namepath = filemd.getFilepath();
            String contens = FileCreate.readFile(namepath);
            map.put("filepath",filemd.getFilepath());
            map.put("filecontent",contens);
            map.put("filename",filemd.getFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    @PostMapping(value = "/deleteFile")
    @ResponseBody
    public int deleteFile(String fileid,String filepath){
        int del = 0;
        try {
            del = iFilemdService.deleteByPrimaryKey(fileid);
            FileCreate.deleteFile(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return del;
    }
}
