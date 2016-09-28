package com.zhangyingwei.hermes.code.action.base;

import com.zhangyingwei.hermes.code.action.result.ResultMap;

/**
 * Created by zhangyw on 2016/9/28.
 */
public class BaseAction {

    protected static final int STATUS_OK = 200;
    protected static final int STATUS_NOTFOUND = 400;
    protected static final int STATUS_ERR = 500;
    protected static final String KEY_MSG="message";
    protected static final String KEY_STATUS="status";
    protected static final String KEY_RESULT="result";
    protected static final String MSG_SUCCESS="success";


    protected ResultMap result = new ResultMap();

    protected ResultMap resultMap(){
        return new ResultMap();
    }
    protected ResultMap resultMsg(String msg){
        return this.resultMap().putValue(KEY_STATUS,STATUS_OK).putValue(KEY_MSG,msg);
    }
    protected ResultMap resultSucc(Object result){
        return this.resultMap().putValue(KEY_STATUS,STATUS_OK).putValue(KEY_MSG,MSG_SUCCESS).putValue(KEY_RESULT,result);
    }
    protected ResultMap resultErr(String msg){
        return this.resultMap().putValue(KEY_STATUS,STATUS_ERR).putValue(KEY_MSG,msg);
    }
}
