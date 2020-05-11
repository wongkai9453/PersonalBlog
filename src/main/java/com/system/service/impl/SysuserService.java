package com.system.service.impl;

import com.system.bean.Sysuser;
import com.system.mapper.SysuserMapper;
import com.system.service.ISysuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName SysuserService
 * @Description 用户查询service
 * @Author wk
 * @Date 2020/5/9 0009 16:16
 * @Version 1.0
 */
@Service
public class SysuserService implements ISysuserService {

    @Resource
    private SysuserMapper sysuserMapper;


    @Override
    public Sysuser selectByPrimaryKey(Long userId) throws Exception {
        return sysuserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Sysuser querySysuser(String loginName) throws Exception {
        return sysuserMapper.querySysuser(loginName);
    }
}
