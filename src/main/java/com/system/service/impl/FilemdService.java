package com.system.service.impl;

import com.system.bean.Filemd;
import com.system.mapper.FilemdMapper;
import com.system.service.IFilemdService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName FilemdService
 * @Description TODO
 * @Author wk
 * @Date 2020/5/11 0011 16:25
 * @Version 1.0
 */
@Service
public class FilemdService implements IFilemdService {
    @Resource
    private FilemdMapper filemdMapper;
    @Override
    public int insert(Filemd record) {
        int result =0;
        try {
            result = filemdMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Filemd> fileList(Long userId) {
        return filemdMapper.fileList(userId);
    }

    /**
     * 功能描述: 
     * @param: 根据文件id查询信息
     * @return: com.system.bean.Filemd
     * @auther: wk
     * @date: 2020/5/12 0012 16:33
     */
    @Override
    public Filemd queryFilemed(String fileid) throws Exception {
        return filemdMapper.selectByPrimaryKey(fileid);
    }

    @Override
    public int deleteByPrimaryKey(String fileid) {
        return filemdMapper.deleteByPrimaryKey(fileid);
    }
}
