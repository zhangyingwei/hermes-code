package com.zhangyingwei.hermes.code.dao.http.impl;

import com.zhangyingwei.hermes.code.common.Common;
import com.zhangyingwei.hermes.code.dao.http.CodeDao;
import com.zhangyingwei.hermes.code.entity.CodeList;
import com.zhangyw.superhttp.http.Http;
import org.apache.commons.httpclient.Cookie;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;
import org.htmlparser.visitors.TextExtractingVisitor;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;

/**
 * Created by zhangyw on 2016/9/28.
 */
@Component(value = "codeDaoImpl")
public class CodeDaoImpl implements CodeDao{
    public List<CodeList> getCodeList() throws Exception {
        List<CodeList> codeLists = new ArrayList<CodeList>();
        String content = new Http().get(Common.URL_CODELIST,Common.COOKIE).getResponseBodyAsString();
        Parser parser = new Parser(content);
        NodeList h3List = parser.extractAllNodesThatMatch(new TagNameFilter("h3"));
        SimpleNodeIterator it = h3List.elements();
        while(it.hasMoreNodes()){
            CodeList codeList = new CodeList();
            Node node = it.nextNode();
            NodeList childs = node.getChildren();
            LinkTag a = (LinkTag) childs.elementAt(1);
            Node div = childs.elementAt(2);
            codeList.setText(a.getLinkText().trim());
            codeList.setLink(a.getLink());
            codeList.setTag(div.toPlainTextString().trim());
            codeLists.add(codeList);
        }
        return codeLists;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new CodeDaoImpl().getCodeList());
    }
}
