package com.jarvan.eventbusdemo;

import java.lang.reflect.Method;

/**
 * 存储被观察者的 回调对象本身
 */
public class SubscriberMethod {

    final Method method;
    final Class<?> eventType;

    public SubscriberMethod(Method method, Class<?> eventType) {
        this.method = method;
        this.eventType = eventType;
    }
//    public SubscriberMethod(Method method) {
//        this.method = method;
//    }
}
