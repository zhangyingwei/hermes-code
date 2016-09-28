package com.zhangyingwei.hermes.code.action.result;

import java.util.HashMap;

/**
 * Created by zhangyw on 2016/9/28.
 */
public class ResultMap<String,Object> extends HashMap <String,Object>{

    public ResultMap putValue(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
