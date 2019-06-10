package com.example.xj.ownproject.presenter;

import com.example.xj.ownproject.view.IBaseView;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public class BasePresenter<V extends IBaseView> {
    private V mView;

    public void attechView(V view) {
        this.mView = view;
    }

    public void dettechView() {
        this.mView = null;
    }

    public V getView() {
        if (mView == null) {
            try {
                throw new Exception("view can not be null");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return mView;
        }
    }


}
