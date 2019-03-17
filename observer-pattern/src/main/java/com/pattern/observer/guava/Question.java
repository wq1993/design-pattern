package com.pattern.observer.guava;

/**
 * Created by wq on 2019/3/17
 */
public class Question {
    /**
     * 提问者
     */
    private String userName;
    /**
     * 提问内容
     */
    private String content;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
