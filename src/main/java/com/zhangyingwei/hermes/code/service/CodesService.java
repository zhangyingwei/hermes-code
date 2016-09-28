package com.zhangyingwei.hermes.code.service;

import com.zhangyingwei.hermes.code.entity.CodeList;

import java.util.List;

/**
 * Created by zhangyw on 2016/9/28.
 */
public interface CodesService {
    public List<CodeList> getCodesList(String qeuery) throws Exception;
}
