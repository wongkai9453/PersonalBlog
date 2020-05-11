package com.system.service;

import com.system.bean.Filemd;

import java.util.List;

public interface IFilemdService {
    int insert(Filemd record);

    List<Filemd> fileList(Long userId);
}