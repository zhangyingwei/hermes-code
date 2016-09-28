package com.zhangyingwei.hermes.code.service.impl;

import com.zhangyingwei.hermes.code.dao.http.CodeDao;
import com.zhangyingwei.hermes.code.entity.CodeList;
import com.zhangyingwei.hermes.code.service.CodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyw on 2016/9/28.
 */
@Service(value = "codeServiceImpl")
public class CodeServiceImpl implements CodesService{

    @Autowired
    private CodeDao codeDaoImpl;
    public List<CodeList> getCodesList(String query) throws Exception {
        List<CodeList> result = new ArrayList<CodeList>();
        List<CodeList> codeLists = this.codeDaoImpl.getCodeList();
        if(query==null){
            return result = codeLists;
        }else{
            for(CodeList code:codeLists){
                if(query.equals(code.getTag())){
                    result.add(code);
                }
            }
        }
        return result;
    }
}
