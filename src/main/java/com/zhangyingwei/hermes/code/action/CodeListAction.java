package com.zhangyingwei.hermes.code.action;

import com.zhangyingwei.hermes.code.action.base.BaseAction;
import com.zhangyingwei.hermes.code.action.result.ResultMap;
import com.zhangyingwei.hermes.code.entity.CodeList;
import com.zhangyingwei.hermes.code.service.CodesService;
import com.zhangyingwei.hermes.code.service.impl.CodeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyw on 2016/9/28.
 */

@Controller
@RequestMapping(value = "hermescode")
public class CodeListAction extends BaseAction{

    private Logger logger = Logger.getLogger(CodeListAction.class);
    @Autowired
    private CodesService codeServiceImpl;

    @RequestMapping(value = "/codes",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap queryCodeList(String query){
        try {
            List<CodeList> codes = this.codeServiceImpl.getCodesList(query);
            return super.resultSucc(codes);
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
            return super.resultErr(e.getLocalizedMessage());
        }
    }
}
