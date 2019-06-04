package com.example.netlibrary.callback;

/**
 * Created by AndroidXJ on 2019/6/4.
 */

public interface INetCallback<T> {

    void success(T t);

    void failed(String message);
}
