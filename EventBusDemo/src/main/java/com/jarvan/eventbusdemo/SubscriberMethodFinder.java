package com.jarvan.eventbusdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *
 */
public class SubscriberMethodFinder {


    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap<>();
    private static final int BRIDGE = 0x40;
    private static final int SYNTHETIC = 0x1000;
    private static final int MODIFIERS_IGNORE = Modifier.ABSTRACT | Modifier.STATIC | BRIDGE | SYNTHETIC;

    List<SubscriberMethod> findSubscriberMethods(Class<?> subscriberClass) {
        List<SubscriberMethod> subscriberMethods = METHOD_CACHE.get(subscriberClass);
        if (subscriberMethods != null) {
            return subscriberMethods;
        }

        subscriberMethods = new ArrayList<>();
        //不考虑指引的方式，使用反射的方式
        //简化方法的遍历
        findUsingReflectionInSingleClass(subscriberMethods, subscriberClass);

        //新产生的，存入缓存中
        METHOD_CACHE.put(subscriberClass, subscriberMethods);
        return subscriberMethods;
    }

    private void findUsingReflectionInSingleClass(List<SubscriberMethod> subscriberMethods, Class<?> subscriberClass) {
        Method[] methods;
        try {
            // This is faster than getMethods, especially when subscribers are fat classes like Activities
            methods = subscriberClass.getDeclaredMethods();
        } catch (Throwable th) {
            methods = subscriberClass.getMethods();
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & Modifier.PUBLIC) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) { //获取有且只要一个参数的方法
                    Subscribe subscribeAnnotation = method.getAnnotation(Subscribe.class);
                    if (subscribeAnnotation != null) { //获取注解为eventbus的存在
                        Class<?> eventType = parameterTypes[0];
                        subscriberMethods.add(new SubscriberMethod(method,eventType));
                    }
                }
            }
        }

    }


}
