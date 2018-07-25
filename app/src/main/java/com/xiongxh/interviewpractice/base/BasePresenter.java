package com.xiongxh.interviewpractice.base;

public interface BasePresenter<V> {
    V getView();

    void subscribe(V view);
    void unsubscribe();
}
