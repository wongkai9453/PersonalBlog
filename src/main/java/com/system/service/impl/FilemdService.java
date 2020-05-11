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
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Resource
    private FilemdMapper filemdMapper;

    @Override
    public int insert(Filemd record) {
        int result;
        result = filemdMapper.insert(record);

        return result;
    }

    @Override
    public List<Filemd> fileList(Long userId) {
        return filemdMapper.fileList(userId);
    }
}
