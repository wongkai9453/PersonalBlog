package com.system.service;

import com.system.bean.Sysuser;

/**
 * @ClassName ISysuserService
 * @Description TODO
 * @Author wk
 * @Date 2020/5/9 0009 16:13
 * @Version 1.0
 */
public interface ISysuserService {
    public Sysuser selectByPrimaryKey(Long userId) throws Exception;

    public Sysuser querySysuser(String loginName)throws Exception;
}
