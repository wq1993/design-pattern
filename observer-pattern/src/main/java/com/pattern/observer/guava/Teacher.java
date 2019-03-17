package com.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by wq on 2019/3/17
 */
public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Subscribe
    public void observerGPer(Object object) {
        GPer gper = (GPer) object;
        System.out.println(this.name + "老师，您好！\n" + "您有一个来自“"
                + gper.getName() + "”的提问需要解答，问题内容："
                + gper.getQuestion().getContent() + "\n提问来自于："
                + gper.getQuestion().getUserName());
    }
}
