package com.system.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName FileCreate
 * @Description TODO
 * @Author wk
 * @Date 2020/5/11 0011 17:59
 * @Version 1.0
 */
public class FileCreate {
    /**
     * 功能描述: 
     * @param: 发布博客生成文件写入内容
     * @return: void
     * @auther: wk
     * @date: 2020/5/11 0011 18:06
     */
    public static boolean touchFile(String namepath,String fileContent) throws IOException {
        String filepath = "src/main/resources/myfile"+namepath;
        File myfile = new File(filepath);
        FileUtils.touch(myfile); //创建文件
        FileUtils.writeStringToFile(myfile,fileContent);
        if(myfile.exists()){ //文件存在
          return true;
        }else{ //如果文件不存在
            return  false;
        }
    }

    /**
     * 功能描述: 
     * @param: 删除文件
     * @return: void
     * @auther: wk
     * @date: 2020/5/12 0012 14:53
     */
    public static void deleteFile(String namepath){
        String filepath = "src/main/resources/myfile"+namepath;
        File myfile = new File(filepath);
        FileUtils.deleteQuietly(myfile); //删除文件
    }

    public static String readFile(String namepath){
        String filepath = "src/main/resources/myfile"+namepath;
        File myfile = new File(filepath);
        String contents = "";
        if(myfile.exists()){
            try {
                contents = FileUtils.readFileToString(myfile,StandardCharsets.UTF_8.name());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contents;
    }
}
