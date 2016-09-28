package com.zhangyingwei.hermes.code.entity;

/**
 * Created by zhangyw on 2016/9/28.
 */
public class CodeList {
    private String text;
    private String link;
    private String tag;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @Override
    public String toString() {
        return "CodeList{" +
                "text='" + text + '\'' +
                ", link='" + link + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
