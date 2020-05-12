package com.system.service;

import com.system.bean.Filemd;

import java.util.List;

public interface IFilemdService {
    int insert(Filemd record);

    List<Filemd> fileList(Long userId);

    /**
     * 功能描述: 
     * @param: 根据文件id查询细腻
     * @return: com.system.bean.Filemd
     * @auther: wk
     * @date: 2020/5/12 0012 16:33
     */
    Filemd queryFilemed(String fileid) throws Exception;
}