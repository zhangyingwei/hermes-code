package com.zhangyingwei.hermes.code.dao.http;

import com.zhangyingwei.hermes.code.entity.CodeList;

import java.util.List;

/**
 * Created by zhangyw on 2016/9/28.
 */
public interface CodeDao {
    public List<CodeList> getCodeList() throws Exception;
}
