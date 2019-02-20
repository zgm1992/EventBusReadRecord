package com.jarvan.eventbusdemo;

public class MessageEvent<T> {
    T mData;

    public MessageEvent(T t) {
        mData = t;
    }

    public MessageEvent() {
    }

    T getData() {
        return mData;
    }
}
