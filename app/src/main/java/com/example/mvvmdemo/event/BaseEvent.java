package com.example.mvvmdemo.event;

/**
 * Date: 2020/2/17
 * Time: 16:45
 * author: cmt
 * desc:
 */
public class BaseEvent<T> {
    private int code;
    private T data;
    public BaseEvent(int code) {
        this.code = code;
    }

    public BaseEvent(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
