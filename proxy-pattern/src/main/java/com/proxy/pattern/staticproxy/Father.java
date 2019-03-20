package com.proxy.pattern.staticproxy;

import com.proxy.pattern.Person;

/**
 * Created by wq on 2019/3/19
 */
public class Father {
    // 代理对象是客户端Father和目标对象Son之间的中介
    // 静态代理就是直接持有目标对象的引用
    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    public void findLover() {
        this.person.findLover();
        System.out.println("老父亲开始物色对象");
        System.out.println("找到了，满意的话可以准备办事了");
    }
}
