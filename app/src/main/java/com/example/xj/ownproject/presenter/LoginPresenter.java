package com.example.xj.ownproject.presenter;

import com.example.xj.ownproject.activity.LoginActivity;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public class LoginPresenter extends BasePresenter {
    private LoginActivity mView;

    public void changeTitle(){
        if(mView==null){
            mView= (LoginActivity) getView();
        }
    }
}
