package com.pattern.observer;

import com.google.common.eventbus.EventBus;
import com.pattern.observer.guava.GPer;
import com.pattern.observer.guava.Question;
import com.pattern.observer.guava.Teacher;

/**
 * Created by wq on 2019/3/17
 */
public class GuavaObserverTest {
    public static void main(String[] args) {
        Question question = new Question();
        question.setUserName("GP16756");
        question.setContent("Guava API 真好用！");
        GPer gper = new GPer();
        gper.setQuestion(question);

        // 消息总线
        EventBus eventBus = new EventBus();
        // 注册观察者
        eventBus.register(new Teacher("Tom"));
        eventBus.register(new Teacher("Mic"));
        // 发送事件
        eventBus.post(gper);
    }
}
