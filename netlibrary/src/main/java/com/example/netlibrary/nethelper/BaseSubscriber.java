package com.example.netlibrary.nethelper;

import android.content.Context;

import com.example.netlibrary.callback.INetCallback;

import rx.Subscriber;

/**
 * Created by AndroidXJ on 2019/6/5.
 */

public class BaseSubscriber<T> extends Subscriber<T> {

    private INetCallback<T> mCallback;
    private Context mContext;

    public BaseSubscriber(INetCallback<T> callback, Context context) {
        this.mCallback = callback;
        this.mContext = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        mCallback.failed(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        mCallback.success(t);
    }
}
