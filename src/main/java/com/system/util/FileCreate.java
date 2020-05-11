package com.system.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

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
     * @param: [namepath, fileContent]
     * @return: void
     * @auther: wk
     * @date: 2020/5/11 0011 18:06
     */
    public static void touchFile(String namepath,String fileContent) throws IOException {
        String filepath = "src/main/resources/myfile"+namepath;
        File myfile = new File(filepath);
        if(myfile.exists()){ //如果文件存在，则删除文件创建信息新的文件
            FileUtils.deleteQuietly(myfile); //删除文件
            FileUtils.touch(myfile);
            FileUtils.writeStringToFile(myfile,fileContent);
        }else{ //如果文件不存在，则创建文件
            FileUtils.touch(myfile); //创建文件
            FileUtils.writeStringToFile(myfile,fileContent);
        }
    }

}
